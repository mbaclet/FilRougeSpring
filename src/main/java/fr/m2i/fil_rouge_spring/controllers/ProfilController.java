package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private ProfilService ps;

//    @GetMapping("/getProfil/{id}")
//    public User getProfil(@PathParam("id") int id){
//        return ps.user;
//    }

}
