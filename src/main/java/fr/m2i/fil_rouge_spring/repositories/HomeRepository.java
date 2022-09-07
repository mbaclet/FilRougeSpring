package fr.m2i.fil_rouge_spring.repositories;

import fr.m2i.fil_rouge_spring.models.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e order by e._id DESC")
    public List<Event> getLastTenEvents(Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.user_id._id = :id")
    public Iterable<Event> getEvents( Long id);
}
