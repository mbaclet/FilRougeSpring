package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.AdminRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AdminService {

    @Autowired
    private AdminRepository ar;

    public Iterable<User> getUsers(){
        return ar.findAll();
    }

    public Iterable<User> getLastTenUsers(){
        return ar.getLastTenUsers(PageRequest.of(0, 10));
    }



}
