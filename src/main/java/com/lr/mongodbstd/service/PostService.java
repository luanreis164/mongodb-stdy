package com.lr.mongodbstd.service;

import com.lr.mongodbstd.domain.Post;
import com.lr.mongodbstd.domain.User;
import com.lr.mongodbstd.dto.UserDTO;
import com.lr.mongodbstd.repository.PostRepository;
import com.lr.mongodbstd.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
