package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.LoginRepository;
import fr.m2i.fil_rouge_spring.repositories.ProfilRepository;
import fr.m2i.fil_rouge_spring.utils.HashText;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Service
public class LoginService {

    @Autowired
    private LoginRepository lr;

    @Autowired
    private HashText ht;

    public Object getLogin(User user){

        String passwordSecur = transformPassword(user.getPassword());
        User userFound = lr.getLogin(user.getEmail());
        if(passwordSecur.equals(userFound.getPassword())){
            userFound.setIsConnected(true);
            lr.save(userFound);
            Map map = new HashMap() {{put("userId", userFound.get_id()); put("token", "aaa");}};
            return map;
        }else{
            return null;
        }
    }



    public String transformPassword(String password){
        try{
            return ht.sha1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean isLog(Optional<User> user) {
        if(user.get().getIsConnected()){
           return true;
        }else {
            return false;
        }
    }

    public Boolean logout(Optional<User> user) {
       try{
           user.get().setIsConnected(false);
           lr.save(user.get());
           return true;
       } catch(Exception e){
           return false;
       }
    }

    public Boolean checkad(Optional<User> user) {
        if(user.get().getRole().equals("ADMIN")){
            return true;
        }else {
            return false;
        }
    }

}
