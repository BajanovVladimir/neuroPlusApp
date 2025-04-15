package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
