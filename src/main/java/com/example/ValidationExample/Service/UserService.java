package com.example.ValidationExample.Service;

import com.example.ValidationExample.Entity.User;
import com.example.ValidationExample.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;

    public User adding(User user){
        return userRepository.save(user);
    }

    public User getUserbyid(int id){
        return userRepository.findById(id).get();
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
