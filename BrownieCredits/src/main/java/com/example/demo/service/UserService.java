package com.example.demo.service;

import com.example.demo.exception.InvalidUserException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userDao;

    public User insertUserRecord(User user){
        if(userDao.existsById(user.getUserId()))
            throw new UserAlreadyExistsException("User already exists");
        return userDao.save(user);
    }

    public List fetchAllRecords(){
        return userDao.findAll();
    }

    public Optional<User> removeUserRecord(String userId){
        if(!userDao.existsById(userId))
            throw new InvalidUserException("User does not exist");

        Optional<User> user = userDao.findById(userId);
        userDao.deleteById(userId);
        return user;
    }

    public Optional<User> fetchUserRecord(String userId){
        if(!userDao.existsById(userId))
            throw new InvalidUserException("User does not exist");
        return userDao.findById(userId);
    }
}
