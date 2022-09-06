package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.ProfilRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProfilService {

    @Autowired
    private ProfilRepository pr;

    public Optional<User> getProfil(Long id) {
        return pr.findById(id);
    }



}
