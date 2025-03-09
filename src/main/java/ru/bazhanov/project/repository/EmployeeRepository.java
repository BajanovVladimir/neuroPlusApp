package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
