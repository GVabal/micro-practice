package dev.vabalas.shoppingservices;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("orders")
public class ShoppingWebService {
    private final OrderRepository orderRepository;
    private final WarehouseClient warehouseClient;

    @GetMapping("init")
    void initSomeOrders() {
        orderRepository.saveAll(List.of(
                new Order("Joe", Set.of(
                        new Thing("Shoe", 2),
                        new Thing("Pant", 2)
                )),
                new Order("Megan", Set.of(
                        new Thing("Fork", 5000),
                        new Thing("Spoon", 2500)
                )),
                new Order("Axel", Set.of(
                        new Thing("Puppy", 1)
                ))
        ));
    }

    @GetMapping
    Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Order takeOrder(@RequestBody OrderRequest orderRequest) {
        return orderRepository.save(orderRequest.toOrder());
    }

    @PostMapping("complete/{id}")
    Order completeOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        order.setShipped(true);
        System.out.printf("Order %d complete!%n", id);
        return orderRepository.save(order);
    }

    void handleUnshippedOrder(Order order) {
        warehouseClient.handleOrderRequest(new OrderDto(order.getId(), order.getCustomer(), order.getThings()));
    }
}
