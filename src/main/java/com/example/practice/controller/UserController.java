package com.example.practice.controller;

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

    //mappings for single item
    @GetMapping("/users/{id}")
    User oneUser(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return repository.findById(id).map(user -> {
            user.setUserName(newUser.getUserName());
            user.setRole(newUser.getRole());
            return repository.save(user);
        }).orElseGet(()->{
            newUser.setId(id);
            return repository.save(newUser);
        });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        repository.deleteById(id);
    }
}
