package com.example.demo.service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userDao;

    public User insertUserRecord(User user){
        if(userDao.existsById(user.getUserId()))
            throw new UserAlreadyExistsException("User already exists");
        return userDao.save(user);
    }
}
