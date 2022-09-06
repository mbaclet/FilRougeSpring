package fr.m2i.fil_rouge_spring.repositories;

import fr.m2i.fil_rouge_spring.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {

   // @Query(value = "SELECT * FROM User ORDER BY id DESC LIMIT 10", nativeQuery = true)
    @Query("SELECT u FROM User u order by u._id DESC")
    public List<User> getLastTenUsers(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.email LIKE :info OR u.city LIKE :info OR u.first_name LIKE :info")
    public List<User> findUser(@Param("info") String info);
}
