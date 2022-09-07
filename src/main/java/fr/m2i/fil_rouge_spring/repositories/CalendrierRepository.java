package fr.m2i.fil_rouge_spring.repositories;

import fr.m2i.fil_rouge_spring.models.Calendrier;
import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.Event;
import fr.m2i.fil_rouge_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalendrierRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.user_id = :user")
    public List<Event> findAllEventLinkToUser(@Param("user") User user);

    @Query(value = "SELECT * FROM Event WHERE user_id = :userid AND MONTH(date) = :mois", nativeQuery = true)
    public List<Event> eventsLinkToUser(@Param("user") Optional<User> user, @Param("mois") Integer mois);

    @Query(value = "SELECT c FROM Calendrier c WHERE c.mois = :mois")
    public List<Calendrier> currentMonth(@Param("mois") Integer mois);

    @Query(value = "SELECT e FROM Event e WHERE e.date = :date AND e.user_id = :user")
    public List<Event> getEvents(@Param("user") Optional<User> user,@Param("date") Integer date);

    //PART GET COLLABORATORS
    @Query("SELECT c.user FROM Collaborator c WHERE c.user_collabo_id = :user AND c.see = true")
    public List<Integer> findIdOfCollaborator(@Param("user") Optional<User> user);

    @Query("SELECT c FROM Collaborator c WHERE c.user_collabo_id = :user AND c.see = true")
    public List<Collaborator> getListCollaborator(@Param("user") Optional<User> user);
}
