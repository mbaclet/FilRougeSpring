package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.LoginRepository;
import fr.m2i.fil_rouge_spring.repositories.ProfilRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Data
//@Service
//public class LoginService {
//
//    @Autowired
//    private LoginRepository lr;
//
//    public Iterable<User> getLogin(String email, String password){
//
//
//
//        return lr.getLogin(email, password);
//    }
//
//
//}
