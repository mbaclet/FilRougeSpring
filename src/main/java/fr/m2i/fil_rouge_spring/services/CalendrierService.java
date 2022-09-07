package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.Calendrier;
import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.CalendrierRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@Service
public class CalendrierService {

    @Autowired
    CalendrierRepository cr;

    @Transactional()
    public Iterable<Event> eventsLinkToUser(Optional<User> user, Integer mois){
        return cr.eventsLinkToUser(user, mois);
    }

    @Transactional()
    public Iterable<Calendrier> currentMonth(Integer mois){
        return cr.currentMonth(mois);
    }

    @Transactional()
    public Iterable<Event> getEvents(Optional<User> user, Integer mois){
        return cr.getEvents(user, mois);
    }

    @Transactional()
    public Optional<Event> getEvent(Long id){
        return cr.findById(id);
    }

    public boolean deleteEvent(Long id){
        try{
            cr.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean saveEvent(Event event){
        try{
            cr.save(event);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //PART GET COLLABORATORS
    @Transactional()
    public Iterable<Integer> findIdOfCollaborator(Optional<User> user){
        return cr.findIdOfCollaborator(user);
    }

    @Transactional()
    public Iterable<Collaborator> getListCollaborator(Optional<User> user){
        return cr.getListCollaborator(user);
    }
}
