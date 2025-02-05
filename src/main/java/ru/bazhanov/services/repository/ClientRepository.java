package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
