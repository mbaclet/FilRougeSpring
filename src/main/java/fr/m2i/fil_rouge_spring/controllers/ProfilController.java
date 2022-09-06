package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.ProfilService;
import fr.m2i.fil_rouge_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private UserService us;

    @GetMapping("/getProfil/{id}")
    public User getProfil(@PathVariable("id") final long id) {
        Optional<User> user = us.getUser(id);
        return user.get();
    }

}
