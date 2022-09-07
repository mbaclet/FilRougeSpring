package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.ContactRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@Service
public class ContactService {

    @Autowired
    private ContactRepository cr;

    @Transactional()
    public Optional<Collaborator> getCollaborator(Long id){
        return cr.findById(id);
    }

    public Iterable<Collaborator> getCollaboratorsById(Long id) {
        return cr.getCollaboratorsById(id);
    }

    public Optional<User> checkCollaborator(String email) {
        return cr.checkCollaborator(email);
    }

    public void deleteCollaborator(long id) {
        cr.deleteById(id);
    }

    public Collaborator checkIfCollaboratorExists(Collaborator collaborator){
        return cr.checkIfCollaboratorExists(collaborator.getUser(), collaborator.getUser_collabo_id());
    }

    public void saveCollaborator(Collaborator collaborator){
        cr.save(collaborator);
    }

    public void editCollaborator() {
        // cr.editCollaborator();
    }
}
