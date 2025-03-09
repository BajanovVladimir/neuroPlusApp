package ru.bazhanov.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.project.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
