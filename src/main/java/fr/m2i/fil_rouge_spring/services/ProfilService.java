package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.repositories.ProfilRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProfilService {

    @Autowired
    private ProfilRepository pr;

//    getReferenceById(ID id);
}
