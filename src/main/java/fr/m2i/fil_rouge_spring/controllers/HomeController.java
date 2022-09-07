package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService hs;

    @GetMapping("/getEvents/{id}")
    public Iterable<Event> getEvents(@PathVariable Long id) {
        return hs.getEvents(id);
    }

    @GetMapping("/getLastEvents")
    public Iterable<Event> getLasTenEvents(){
        return hs.getLastTenEvents();
    }
}
