package com.example.questapp.Controller;


import com.example.questapp.entities.User;
import com.example.questapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public void saveUser(@RequestBody User newUser){
       if(newUser !=null) {
           newUser.setId(0);
           userService.saveUser(newUser);
       }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User newUser){
        Optional<User> user = userService.getOneUser(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUser_name(newUser.getUser_name());
            foundUser.setPassword(newUser.getPassword());
            userService.saveUser(foundUser);
            return  foundUser;

        }else{
            return  null;

        }
    }
}
