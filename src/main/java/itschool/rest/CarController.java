package itschool.rest;

import itschool.entity.Car;
import itschool.entity.RentalReturnDate;
import itschool.exceptions.CarOutOfStock;
import itschool.repository.CarRepository;
import itschool.repository.RentalReturnDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RentalReturnDateRepository rentalReturnDateRepository;

    @GetMapping(value = "/car/all")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "all-cars";
    }

    @GetMapping(value = "/car/save")
    public String saveCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-cars";
    }

    @PostMapping(value = "/car/save")
    public String saveCars(@ModelAttribute("car") @RequestBody Car car,RedirectAttributes redirectAttributes) {
        carRepository.save(car);
        redirectAttributes.addFlashAttribute("message1", "The car has been saved successfully.");
        return "redirect:/car/save";
    }


    @GetMapping(value = "/car/rent/{id}")
    public String rentCarForm(@PathVariable("id") Long id, Model model) {
        Car car = carRepository.getById(id);
        RentalReturnDate rentalReturnDate = new RentalReturnDate();
        rentalReturnDate.setReturnDate(rentalReturnDate.getRentalDate().plusDays(7));
        model.addAttribute("rentalReturnDate", rentalReturnDate);
        model.addAttribute("car", car);
        return "rent-car";
    }

    @PostMapping(value = "/car/rent/{id}")
    public String rentCar(@PathVariable("id") Long id, @ModelAttribute("rentalReturnDate")
    @RequestBody RentalReturnDate rentalReturnDate, RedirectAttributes redirectAttributes) {
        rentalReturnDate.setReturnDate(rentalReturnDate.getRentalDate().plusDays(7));
        rentalReturnDateRepository.save(rentalReturnDate);
        Car car = carRepository.getById(id);
        car.setRentalReturnDate(rentalReturnDate);
        try {
            if (car.getQuantity() > 0) {
                car.setQuantity(car.getQuantity() - 1);
            } else {
                throw new CarOutOfStock("The car is out of stock!");
            }
        } catch (CarOutOfStock coos) {
            System.out.println(coos);
        }

        carRepository.save(car);
        redirectAttributes.addFlashAttribute("message1", "The car has been rented successfully.");
        return "redirect:/car/all";
    }

    @GetMapping("/car/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id, Model model) {
        carRepository.deleteById(id);
        return "redirect:/car/all";
    }


    @GetMapping("/car/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", carRepository.getById(id));
        return "update-car";
    }

    @RequestMapping("/car/update/{id}")
    public String updateCar(@PathVariable("id") Long id, @ModelAttribute Car newCar, Model model) {
        Car oldCar = carRepository.getById(id);
        try {
            if (newCar.getCarName() != null) {
                oldCar.setCarName(newCar.getCarName());
            }
            if (newCar.getNrOfDoors() != null) {
                oldCar.setNrOfDoors(newCar.getNrOfDoors());
            }
            if (newCar.getColor() != null) {
                oldCar.setColor(newCar.getColor());
            }
            if (newCar.getQuantity() != null) {
                oldCar.setQuantity(newCar.getQuantity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("car", oldCar);
        carRepository.save(oldCar);
        return "redirect:/car/all";
    }
}
