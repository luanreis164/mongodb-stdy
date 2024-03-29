package com.lr.mongodbstd.config;

import com.lr.mongodbstd.domain.Post;
import com.lr.mongodbstd.domain.User;
import com.lr.mongodbstd.dto.AuthorDTO;
import com.lr.mongodbstd.dto.CommentDTO;
import com.lr.mongodbstd.repository.PostRepository;
import com.lr.mongodbstd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User goku = new User(null,"Goku ","goku@gmail.com");
        User luffy = new User(null,"Luffy","luffy@gmail.com");
        User naruto = new User(null,"Naruto","Naruto@gmail.com");
        userRepository.saveAll(Arrays.asList(goku,luffy,naruto));

        Post post1 = new Post(null,sdf.parse("13/04/2022"),"GOMU GOMU NO !","ROCKETTT!",new AuthorDTO(luffy));
        Post post2 = new Post(null,sdf.parse("14/04/2022"),"Freeza!","Por que matou o kuririn?",new AuthorDTO(goku));

        CommentDTO c1 = new CommentDTO("Bora lutar?",sdf.parse("14/04/2022"),new AuthorDTO(goku));
        CommentDTO c2 = new CommentDTO("Também quero lutar!",sdf.parse("14/04/2022"),new AuthorDTO(naruto));
        CommentDTO c3 = new CommentDTO("Eu estou nervoso!",sdf.parse("14/04/2022"),new AuthorDTO(goku));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));
        postRepository.saveAll(Arrays.asList(post1,post2));


        goku.getPosts().addAll(Arrays.asList(post2));
        luffy.getPosts().addAll(Arrays.asList(post1));
        userRepository.saveAll(Arrays.asList(goku,luffy));



    }

}
