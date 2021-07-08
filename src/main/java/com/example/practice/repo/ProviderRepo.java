package com.example.practice.repo;

import com.example.practice.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepo extends JpaRepository<Provider, Long> {
}
