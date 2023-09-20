package com.paulohenrique.course.repositories;

import com.paulohenrique.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
