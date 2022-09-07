package fr.m2i.fil_rouge_spring.controllers;

import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService hs;

    @GetMapping("/getLastTenEvents")
    public Iterable<Event> getLasTenEvents(){
        return hs.getLastTenEvents();
    }
}
