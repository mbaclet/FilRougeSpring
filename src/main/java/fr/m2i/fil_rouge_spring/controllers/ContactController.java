package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Optional<User> checkCollaborator (@RequestBody String email) {
        return cs.checkCollaborator(email);
    }

    @PostMapping("/deleteCollaborator")
    public void deleteCollaborator(@RequestBody long id) {
        cs.deleteCollaborator(id);
    }

    @PostMapping("/addCollaborator")
    public Boolean addCollaborator(@RequestBody Collaborator collaborator) {
        try{
            Collaborator collaborator1 = cs.checkIfCollaboratorExists(collaborator);
            if(collaborator1 != null){
                return false;
            }else{
                cs.saveCollaborator(collaborator);
                return true;
            }
        }catch(Exception e){
            return false;
        }
    }

    @PostMapping("/editCollaborator")
    public void editCollaborator(@RequestBody ArrayList<String> collaborator) {
        long convertIdToLong = Integer.toUnsignedLong(Integer.parseInt(collaborator.get(3).toString()));
        Optional<Collaborator> collabFound = cs.getCollaborator(convertIdToLong);
        if(collabFound.isPresent()){
            Collaborator currentCollabo = collabFound.get();
            currentCollabo.setSee(collaborator.get(0).toString().equals("true"));
            currentCollabo.setEdit(collaborator.get(1).toString().equals("true"));
            currentCollabo.setShare(collaborator.get(2).toString().equals("true"));
            cs.saveCollaborator(currentCollabo);
        }
        cs.editCollaborator();
    }

}
