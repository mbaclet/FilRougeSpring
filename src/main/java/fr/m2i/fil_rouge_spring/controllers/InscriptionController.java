package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    private InscriptionService is;

    @PostMapping("/getInscription")
    public Boolean addUser(@RequestBody User user){
        try{
            Optional<User> isUserExist = is.findUserByEmail(user.getEmail());
            if(!isUserExist.isPresent()){
                is.saveUser(user);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
