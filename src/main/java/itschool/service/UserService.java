package itschool.service;

import itschool.entity.MyUser;
import org.springframework.stereotype.Service;

import java.util.List;

//aici am facut abstractizare
//chem metoda din interfata, nu din clasa
//controller-ul stie sa se duca in cine implementeaza interfata si sa ia metoda
@Service
public interface UserService{

    MyUser findUserByEmail(String email);

    MyUser findUserByUserName(String userName);

    boolean findUserByUserNameAndPassword(String userName, String password);

    List<MyUser> findAll();

    void deleteById(long id);

    MyUser saveUser(MyUser u);
}
