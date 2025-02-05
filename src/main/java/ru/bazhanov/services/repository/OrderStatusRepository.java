package ru.bazhanov.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazhanov.services.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
