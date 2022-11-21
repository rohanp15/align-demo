package com.AlignTest.assessment.controller;

import com.AlignTest.assessment.model.User;
import com.AlignTest.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/health")
    public String health() {
        return "Hello & Welcome to Align !!!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/update/users/{user_id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable(value = "user_id") Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @RequestMapping(value = "/delete/users/{user_id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "user_id") Long id){
        userService.deleteUser(id);
    }
}
