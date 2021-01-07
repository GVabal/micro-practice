package dev.vabalas.factoryservices;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ScheduledTasks {
    private final OrderRepository orderRepository;
    private final WarehouseClient warehouseClient;

    @Scheduled(fixedRate = 30000)
    void handleOrders() {
        System.out.println("task started");
        List<Order> ordersToHandle = orderRepository.findAllByIsHandledIsFalse();
        if (ordersToHandle.size() > 0) {
            System.out.printf("Found %d orders to handle.%n", ordersToHandle.size());
            ordersToHandle.forEach(order -> {
                ThingDto thing = new ThingDto(
                        order.getThingName(),
                        order.getAmount() < 100 ? 100 : order.getAmount()
                );
                warehouseClient.doThing(thing);
                order.setHandled(true);
                orderRepository.save(order);
            });
        }
    }
}
