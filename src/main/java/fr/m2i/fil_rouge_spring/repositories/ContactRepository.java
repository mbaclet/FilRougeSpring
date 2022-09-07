package fr.m2i.fil_rouge_spring.repositories;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Collaborator, Long> {

    @Query("SELECT c FROM Collaborator c WHERE c.user = :userId")
    public List<Collaborator> getCollaboratorsById(@Param("userId") Long id);

    @Query("SELECT u FROM User u WHERE u.email LIKE :email")
    public Optional<User> checkCollaborator(@Param("email") String email);

    @Query("SELECT c FROM Collaborator c WHERE c.user = :id AND c.user_collabo_id = :user_collabo_id")
    public Collaborator checkIfCollaboratorExists(@Param("id") Long id, @Param("user_collabo_id") User user_collabo_id);


    @Query("SELECT c FROM Collaborator c WHERE c.user = :id")
    public List<Collaborator> findAllCollaboLinkToUser(@Param("id") Long id);


}

