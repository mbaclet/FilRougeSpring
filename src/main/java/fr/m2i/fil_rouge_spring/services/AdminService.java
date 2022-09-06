package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.AdminRepository;
import fr.m2i.fil_rouge_spring.repositories.CalendrierRepository;
import fr.m2i.fil_rouge_spring.repositories.ContactRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Data
@Service
public class AdminService {

    @Autowired
    private AdminRepository ar;

    @Autowired
    private ContactRepository cr;

    @Autowired
    private CalendrierRepository calr;

    public Optional<User> getOneUser(final Long id){
        return ar.findById(id);
    }

    public Iterable<User> getUsers(){
        return ar.findAll();
    }

    public Iterable<User> getLastTenUsers(){
        return ar.getLastTenUsers(PageRequest.of(0, 10));
    }

    public Iterable<User> findUser(String info){
        return ar.findUser(info);
    }

    public User saveUser(User user) {
        User save = ar.save(user);
        return save;
    }

    public void deleteUser(Long id) {
        ar.deleteById(id);
    }

    public void deleteEvent(User user) {
        Iterable<Event> events = calr.findAllEventLinkToUser(user);
        for (Event event : events){
            calr.deleteById(event.get_id().longValue());
        }
    }

    public void deleteCollabo(Long id) {
        Iterable<Collaborator> collaborators = cr.findAllCollaboLinkToUser(id);
        for(Collaborator collabo:collaborators){
            cr.deleteById(collabo.get_id().longValue());
        }

    }

}
