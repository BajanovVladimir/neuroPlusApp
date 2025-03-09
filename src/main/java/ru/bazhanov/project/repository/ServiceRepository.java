package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.OurService;

public interface ServiceRepository extends JpaRepository<OurService,Integer> {
}
