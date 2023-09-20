package com.paulohenrique.course.repositories;

import com.paulohenrique.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
