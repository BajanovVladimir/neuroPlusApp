package ru.bazhanov.identification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.identification.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLogin(String login);
}
