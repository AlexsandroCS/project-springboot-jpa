package com.educandoweb.course.config;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Alexsandro Grey", "Alexsandro@gmail.com", "111111111","123456");
        User u2 = new User(null,"Fernanda Purple", "Fernanda@gmail.com","222222222","1234567");

        Order o1 = new Order(null, Instant.parse("2023-04-12T02:46:02Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-04-12T02:46:22Z"), OrderStatus.WAITING_PAYMENTY, u1);
        Order o3 = new Order(null, Instant.parse("2023-04-12T02:46:42Z"), OrderStatus.WAITING_PAYMENTY, u2);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}