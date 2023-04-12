package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Alexsandro Grey", "Alexsandro@gmail.com", "111111111","123456");
        User u2 = new User(null,"Fernanda Purple", "Fernanda@gmail.com","222222222","1234567");

        Order o1 = new Order(null, Instant.parse("2023-04-12T02:46:02Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-04-12T02:46:22Z"), u1);
        Order o3 = new Order(null, Instant.parse("2023-04-12T02:46:42Z"), u2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}