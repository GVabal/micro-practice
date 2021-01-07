package dev.vabalas.factoryservices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FactoryWebService {
    private final OrderRepository orderRepository;

    @GetMapping
    Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("take-order")
    Order takeSingleThingOrder(@RequestParam String name, @RequestParam Integer qty) {
        return orderRepository.save(new Order(name, qty));
    }
}
