package ru.bazhanov.identification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.User;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByUser(User user);
}
