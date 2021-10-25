package com.selevn.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){

    }

    public User getById(Integer id){
        return userRepository.findById(id);
    }
}