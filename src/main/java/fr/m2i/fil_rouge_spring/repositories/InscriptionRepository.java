package fr.m2i.fil_rouge_spring.repositories;

import fr.m2i.fil_rouge_spring.models.Collaborator;
import fr.m2i.fil_rouge_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email LIKE :email")
    public Optional<User> findUserByEmail(@Param("email") String email);
}
