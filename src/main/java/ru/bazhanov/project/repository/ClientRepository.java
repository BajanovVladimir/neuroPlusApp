package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
