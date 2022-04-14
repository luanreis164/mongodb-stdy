package com.lr.mongodbstd.service;

import com.lr.mongodbstd.domain.Post;
import com.lr.mongodbstd.domain.User;
import com.lr.mongodbstd.dto.UserDTO;
import com.lr.mongodbstd.repository.PostRepository;
import com.lr.mongodbstd.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    //Metodo de busca por email
    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //Metodo de busca por texto
    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

    //Metodo de busca completa por texto e datas de postagem
    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

}
