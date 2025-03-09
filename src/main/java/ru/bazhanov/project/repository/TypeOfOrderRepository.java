package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.TypeOfOrder;

public interface TypeOfOrderRepository extends JpaRepository<TypeOfOrder, Integer> {
}
