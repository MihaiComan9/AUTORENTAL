package itschool.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String carName;

    @Column(nullable = false, length = 1)
    private Integer nrOfDoors;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "car_manufacturer",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
    private Set<Manufacturer> manufacturers;

    @ManyToOne(cascade = CascadeType.ALL)
    private Factory factory;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Type.class)
    private Set<Type> types;

    @ManyToOne
    private MyUser user;

    @ManyToOne
    private RentalReturnDate rentalReturnDate;

}
