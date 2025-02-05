package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
