package com.lr.mongodbstd.service;

import com.lr.mongodbstd.domain.User;
import com.lr.mongodbstd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }


}
