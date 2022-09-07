package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.InscriptionRepository;
import fr.m2i.fil_rouge_spring.utils.HashText;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Data
@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository ir;

    @Autowired
    private HashText ht;

    public Optional<User> findUserByEmail(String email){
        return ir.findUserByEmail(email);
    }

    public void saveUser(User user){
        String hashPassword = transformPassword(user.getPassword());
        user.setPassword(hashPassword);
        ir.save(user);
    }

    public String transformPassword(String password){
        try{
            return ht.sha1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
