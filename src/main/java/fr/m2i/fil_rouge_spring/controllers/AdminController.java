package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
