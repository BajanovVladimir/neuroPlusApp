package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.Service;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
