package com.lr.mongodbstd.config;

import com.lr.mongodbstd.domain.User;
import com.lr.mongodbstd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User goku = new User(null,"Goku ","goku@gmail.com");
        User luffy = new User(null,"Luffy","luffy@gmail.com");
        User naruto = new User(null,"Naruto","Naruto@gmail.com");

        userRepository.saveAll(Arrays.asList(goku,luffy,naruto));


    }

}
