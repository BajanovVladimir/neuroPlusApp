package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.TypeOfOrder;

public interface TypeOfOrderRepository extends JpaRepository<TypeOfOrder, Integer> {
}
