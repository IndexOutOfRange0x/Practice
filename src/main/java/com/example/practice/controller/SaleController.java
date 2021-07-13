package com.example.practice.controller;

import com.example.practice.domain.Sale;
import com.example.practice.repo.SaleRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {
    private final SaleRepo repository;

    public SaleController(SaleRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/sales")
    List<Sale> allSales(){
        return repository.findAll();
    }

    @PostMapping("/sales")
    Sale newSale(@RequestBody Sale sale){
        return repository.save(sale);
    }

    @GetMapping("sales/{id}")
    Sale oneSale(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    @PutMapping("/sales/{id}")
    Sale updateSale(@RequestBody Sale newSale, @PathVariable Long id){
        return repository.findById(id).map(sale ->{
           sale.setBuyer(newSale.getBuyer());
           sale.setProduct(newSale.getProduct());
           sale.setDateOfOperation(newSale.getDateOfOperation());
           return repository.save(sale);
        }).orElseGet(() ->{
            newSale.setId(id);
            return repository.save(newSale);
        });
    }

    @DeleteMapping("sales/{id}")
    void deleteSale(@PathVariable long id){
        repository.deleteById(id);
    }

}
