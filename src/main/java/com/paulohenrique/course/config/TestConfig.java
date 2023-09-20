package com.paulohenrique.course.config;

import com.paulohenrique.course.entities.Order;
import com.paulohenrique.course.entities.User;
import com.paulohenrique.course.repositories.OrderRepository;
import com.paulohenrique.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User();
        u1.setName("Maria Brown");
        u1.setEmail("maria@gmail.com");
        u1.setPhone("988888888");
        u1.setPassword("123456");

        User u2 = new User();
        u2.setName("Alex Green");
        u2.setEmail("alex@gmail.com");
        u2.setPhone("977777777");
        u2.setPassword("123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
