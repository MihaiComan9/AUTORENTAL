package itschool.service.impl;

import itschool.entity.MyUser;
import itschool.entity.Role;
import itschool.repository.RoleRepository;
import itschool.repository.UserRepository;
import itschool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//tot ce este anotat cu service/entity/controllor/restcontroller etc.,
        // cand porneste aplicatia sunt inregistrare ca bean-uri intr-un container
        //cand dam autowired nu mai au nevoie de implementare pentru ca au fost deja create la porninre aplicatie

@Service
public class UserServiceImpl implements UserService {

    //le avem final pentru ca ele nu isi mai pot schimba valoarea
    //astfel trebuie sa avem constructor cu initializarea lor

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired //se poate pune ori aici pe constructor, ori deasupra fiecaruia
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public MyUser findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public MyUser findUserByUserName(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName);
    }

    //fiind un boolean ne spune doar daca exista in baza de date sau nu (A/F)
    //acest optional tine in el null sau o valoare efectiva; ne fereste de nullpointerexception
    public boolean findUserByUserNameAndPassword(String userName, String password) {
        final Optional<MyUser> myUser = Optional.ofNullable(userRepository.findByUsernameIgnoreCase(userName));
        return myUser.filter(user -> BCrypt.checkpw(password, user.getPassword())).isPresent();
    }

    public List<MyUser> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public MyUser saveUser(MyUser u) { //u va fi primit din controller
        MyUser user = new MyUser(u);
        //BCrypt: stie sa encodeze parola incat sa nu poata fi decodata, folosind un algoritm
        //encodezi de mai multe ori si va avea de fiecare data valori diferite
        //tot el vine cu o metoda de match: ia parola noua, o encodeaza si o verifica la cea existenta
        //deci el stie ca provin din acelasi String cand se face match
        user.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        u.getRoles().forEach(role -> {
            //pentru fiecare rol al userului, verificam daca rolul exista deja in DB
            final Role roleByName = roleRepository.findByName(role.getName());
            //daca nu exista rolul, atunci il salvam
            if (roleByName == null)
                user.getRoles().add(roleRepository.save(role));
            //daca exista, ii setam ID-ul userului
            else {
                role.setId(roleByName.getId());
            }
        });
        //cand se face save, se face save si la rol
        return userRepository.save(user);
    }

}

//pentru Optional : inseamna ca interiorul variabilei myUser poate exista null
//daca ce este adus din baza de date vine cu null, in mod normal ar veni NullPointerException
//deci optional poate retine null sau valoarea efectiva
