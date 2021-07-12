package com.example.practice.controller;

import com.example.practice.domain.Role;
import com.example.practice.repo.RoleRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    private final RoleRepo repository;

    RoleController(RoleRepo roleRepo){
        repository = roleRepo;
    }

    @GetMapping("/roles")
    List<Role> allRoles(){
        return repository.findAll();
    }

    @PostMapping("/roles")
    Role newRole(@RequestBody Role role){
        return repository.save(role);
    }

    @DeleteMapping("/roles/{id}")
    void deleteRole(@PathVariable Long id){
        repository.deleteById(id);
    }
}
