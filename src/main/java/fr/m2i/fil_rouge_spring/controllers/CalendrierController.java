package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.Calendrier;
import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.services.CalendrierService;
import fr.m2i.fil_rouge_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/planning")
public class CalendrierController {

    @Autowired
    private CalendrierService cs;

    @Autowired
    private UserService us;

    @GetMapping("/getDates/{mois}/{userId}")
    public Map<String,Object> getDates(@PathVariable("mois") Integer mois, @PathVariable("userId") final long userid){

        Optional<User> user = us.getUser(userid);
        Iterable<Event> eventsLinkToUser = cs.eventsLinkToUser(user, mois);
        Iterable<Calendrier> calendriers = cs.currentMonth(mois);

        Map<String, Object> theThings = new HashMap<>();
        //do things to get the Map built
        theThings.put("calendrier", calendriers);
        theThings.put("event", eventsLinkToUser);

        return theThings;
    }

    @PostMapping("/getEvents")
    public Iterable<Event> getEvents(@RequestBody ArrayList info) {
        long convertIdToLong = Integer.toUnsignedLong(Integer.parseInt(info.get(1).toString()));
        Optional<User> user = us.getUser(convertIdToLong);

        return cs.getEvents(user, Integer.parseInt(info.get(0).toString()));
    }

    @PostMapping("/getEvent")
    public Optional<Event> getEvent(@RequestBody Long id) {
        return cs.getEvent(id);
    }

    @GetMapping("/deleteEvent/{id}")
    public Boolean getDates(@PathVariable("id") long id) {
        return cs.deleteEvent(id);
    }

    @PostMapping("/addEvent")
    public Boolean addEvent(@RequestBody Event event) {
        return cs.saveEvent(event);
    }

    @PostMapping("/editEvent")
    public Boolean editEvent(@RequestBody List event) {
        long convertIdToLong = Integer.toUnsignedLong(Integer.parseInt(event.get(5).toString()));
        Optional<Event> eventFound = cs.getEvent(convertIdToLong);
        if(eventFound.isPresent()) {
            Event currentEvent = eventFound.get();
            currentEvent.setTitle(event.get(0).toString());
            currentEvent.setDescription(event.get(1).toString());
            currentEvent.setTime_begin(Integer.parseInt(event.get(2).toString()));
            currentEvent.setTime_end(Integer.parseInt(event.get(3).toString()));
            currentEvent.setVisibility(event.get(4).toString());

            cs.saveEvent(currentEvent);
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/getOneUser/{id}")
    public Optional<User> getOneUser(@PathVariable("id") long id) {
        return us.getUser(id);
    }

    @GetMapping("/getCollaborator/{id}")
    public List<Optional<User>> getCollaborator(@PathVariable("id") long id) {
        List<Optional<User>> collaborators = new ArrayList<>();
        try{
            Optional<User> user = us.getUser(id);
            Iterable<Integer> users = cs.findIdOfCollaborator(user);
            for(Integer userid:users){
                Optional<User> collabo = us.getUser(userid.longValue());
                collaborators.add(collabo);
            }
            return collaborators;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/getListCollaborator/{id}")
    public Iterable<Collaborator> getListCollaborator(@PathVariable("id") long id) {
        Optional<User> user = us.getUser(id);
        return cs.getListCollaborator(user);
    }




}
