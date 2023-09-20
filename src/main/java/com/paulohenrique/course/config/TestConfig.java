package com.paulohenrique.course.config;

import com.paulohenrique.course.entities.Order;
import com.paulohenrique.course.entities.User;
import com.paulohenrique.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Order> orders = new ArrayList<>();

        User u1 = new User(null,
                "Maria Brown",
                "maria@gmail.com",
                "988888888",
                "123456",
                orders);
        User u2 = new User(null,
                "Alex Green",
                "alex@gmail.com",
                "977777777",
                "123456",
                orders);

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
