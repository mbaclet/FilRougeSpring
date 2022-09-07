package fr.m2i.fil_rouge_spring.services;

import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    HomeRepository hr;

    public Iterable<Event> getEvents(Long id) {
        return hr.getEvents(id);
    }

    public Iterable<Event> getLastTenEvents(){
        return hr.getLastTenEvents(PageRequest.of(0, 10));
    }
}
