package com.example.questapp.service;

import com.example.questapp.entities.User;
import com.example.questapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getOneUser(Long id){
        return userRepository.findById(id).orElse(null);
    }


    public void saveUser(User user){
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id){

   userRepository.deleteById(id);
    }


    public User updateUser(Long id, User newUser){
        Optional<User> user = Optional.ofNullable(getOneUser(id));
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUser_name(newUser.getUser_name());
            foundUser.setPassword(newUser.getPassword());
            saveUser(foundUser);
            return  foundUser;

        }else{
            return  null;
    }}
}
