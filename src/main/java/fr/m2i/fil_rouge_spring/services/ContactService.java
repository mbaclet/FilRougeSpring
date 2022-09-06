package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.ContactRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ContactService {

    @Autowired
    private ContactRepository cr;

    public Iterable<Collaborator> getCollaboratorsById(Long id) {
        return cr.getCollaboratorsById(id);
    }

    public User checkCollaborator(String email) {
        return cr.checkCollaborator(email);
    }
}
