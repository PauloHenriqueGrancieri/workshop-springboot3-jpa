package com.paulohenrique.course.repositories;

import com.paulohenrique.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
