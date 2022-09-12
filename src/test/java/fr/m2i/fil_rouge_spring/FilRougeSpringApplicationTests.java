package fr.m2i.fil_rouge_spring;

import fr.m2i.fil_rouge_spring.models.User;
import fr.m2i.fil_rouge_spring.repositories.AdminRepository;
import fr.m2i.fil_rouge_spring.services.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FilRougeSpringApplicationTests {

    @MockBean
    private AdminRepository ar;

    @Autowired
    private AdminService as;

    @Test
    void contextLoads() {
    }

    @Test
    void getUsersTest(){
        List<User> users = new ArrayList<>();

        when(ar.findAll()).thenReturn(users);

        Iterable<User> answer = as.getUsers();

        verify(ar).findAll();
        assertThat(users.equals(answer));
    }

    @Test
    void getUserByEmailTest(){
        List<User> users = new ArrayList<>();

        when(ar.findUser("lyon")).thenReturn(users);

        Iterable<User> answer = as.findUser("lyon");

        verify(ar).findUser("lyon");
        assertThat(users.equals(answer));
    }

    @Test
    void getUserByIdTest(){
        Optional<User> user = Optional.of(new User());

        when(ar.findById((long)1)).thenReturn(user);

        Optional<User> answer = as.getOneUser((long)1);

        verify(ar).findById((long)1);
        assertThat(user.equals(answer));
    }

}
