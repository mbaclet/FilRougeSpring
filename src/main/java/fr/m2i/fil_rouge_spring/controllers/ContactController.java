package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService cs;

    @GetMapping("/getCollaborators/{id}")
    public Iterable<Collaborator> getCollaborator(@PathVariable("id") final long id) {
        return cs.getCollaboratorsById(id);
    }

    @PostMapping("/checkCollaborator")
    public User checkCollaborator (@RequestBody String email) {
        return cs.checkCollaborator(email);
    }

    @PostMapping("/deleteCollaborator")
    public void deleteCollaborator(Long id, Long user) {
        cs.deleteCollaborator(id);
    }

//    @PostMapping("/addCollaborator")
//    public Collaborator addCollaborator() {
//        return cs.addCollaborator();
//    }

}
