package fr.m2i.fil_rouge_spring.repositories;

import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendrierRepository extends JpaRepository<User, Long> {

    @Query("SELECT e FROM Event e WHERE e.user_id = :user")
    public List<Event> findAllEventLinkToUser(@Param("user") User user);
}
