package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService as;

    @GetMapping("/getUsers")
    public Iterable<User> getUsers(){
        return as.getUsers();
    }

    @GetMapping("/getLastTenUsers")
    public Iterable<User> getLastTenUsers(){
        return as.getLastTenUsers();
    }

    @PostMapping("/findUser")
    public Iterable<User> findUser(@RequestBody String info) {
        return as.findUser(info);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return as.saveUser(user);
    }

    @PostMapping("/editUser")
    public void editUser(@RequestBody ArrayList userInfo) {
        Optional<User> user = as.getOneUser((Long) userInfo.get(0));
        if(user.isPresent()) {
            User currentUser = user.get();
            currentUser.setRole(userInfo.get(1).toString());
            as.saveUser(currentUser);
        }

    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody Long id) {
        deleteEvent(id);
        deleteCollabo(id);

        as.deleteUser(id);
    }

    public void deleteEvent(Long id) {
        Optional<User> user = as.getOneUser(id);
        as.deleteEvent(user.get());
    }

    public void deleteCollabo(Long id) {
        as.deleteCollabo(id);
    }



}
