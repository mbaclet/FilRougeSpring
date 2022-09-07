package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.LoginService;
import fr.m2i.fil_rouge_spring.services.ProfilService;
import fr.m2i.fil_rouge_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService ls;

    @Autowired
    private UserService us;

    @GetMapping("/getLogin")
    public String getLogin(@RequestBody User user){
        return ls.getLogin(user);
    }

    @PostMapping("/isLog")
    public Boolean isLog(@RequestBody long userId){
        Optional<User> user = us.getUser(userId);

        return ls.isLog(user);
    }

    @PostMapping("/logout")
    public Boolean logout(@RequestBody long userId){
        Optional<User> user = us.getUser(userId);

        return ls.logout(user);
    }

    @PostMapping("/checkad")
    public Boolean checkad(@RequestBody long userId){
        Optional<User> user = us.getUser(userId);

        return ls.checkad(user);
    }

}
