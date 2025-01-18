package ru.bazhanov.identification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.identification.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
}
