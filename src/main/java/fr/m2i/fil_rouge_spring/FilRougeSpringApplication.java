package fr.m2i.fil_rouge_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilRougeSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FilRougeSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
