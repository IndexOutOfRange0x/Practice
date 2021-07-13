package com.example.practice.controller;

import com.example.practice.domain.Provider;
import com.example.practice.repo.ProviderRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {
    private final ProviderRepo repository;

    public ProviderController(ProviderRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/providers")
    List<Provider> allProviders(){
        return repository.findAll();
    }

    @PostMapping("/providers")
    Provider newProvider(@RequestBody Provider provider){
        return repository.save(provider);
    }

    //mappings for single item
    @GetMapping("/providers/{id}")
    Provider oneProviders(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/providers/{id}")
    Provider updateProvider(@RequestBody Provider newProvider, @PathVariable Long id){
        return repository.findById(id).map(provider -> {
            provider.setNameOfOrganization(newProvider.getNameOfOrganization());
            provider.setProduct(newProvider.getProduct());
            provider.setDiscount(newProvider.getDiscount());
            return repository.save(provider);
        }).orElseGet(()->{
            newProvider.setId(id);
            return repository.save(newProvider);
        });
    }

    @DeleteMapping("/providers/{id}")
    void deleteProvider(@PathVariable Long id){
        repository.deleteById(id);
    }
}
