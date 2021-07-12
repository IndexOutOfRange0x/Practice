package com.example.practice.controller;

import com.example.practice.repo.RoleRepo;
import com.example.practice.repo.UserRepo;
import com.example.practice.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepo repository;

    UserController(UserRepo userRepo){
        repository = userRepo;
    }

    @GetMapping("/users")
    List<User> allUsers(){
       return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user){
        return repository.save(user);
    }

    @GetMapping("/users/{id}")
    User oneUser(@PathVariable Long id){
        return repository.findById(id);
                //.orElseThrow(() -> new Exception(""));
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        repository.deleteById(id);
    }
}
