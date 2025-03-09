package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
