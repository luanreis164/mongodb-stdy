package com.lr.mongodbstd.service;

import com.lr.mongodbstd.domain.User;
import com.lr.mongodbstd.dto.UserDTO;
import com.lr.mongodbstd.repository.UserRepository;
import com.lr.mongodbstd.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
