package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
