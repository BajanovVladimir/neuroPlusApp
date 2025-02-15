package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.OurService;

public interface ServiceRepository extends JpaRepository<OurService,Integer> {
}
