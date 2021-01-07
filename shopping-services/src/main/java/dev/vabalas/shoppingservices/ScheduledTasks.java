package dev.vabalas.shoppingservices;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private final OrderRepository orderRepository;
    private final ShoppingWebService shoppingWebService;

    @Scheduled(fixedRate = 60000)
    void processUnshippedOrders() {
        List<Order> orders = orderRepository.findAllByIsShippedFalse();
        if (orders.size() > 0) {
            LOGGER.info(String.format("Found %d unshipped orders. Handling...", orders.size()));
            orders.forEach(shoppingWebService::handleUnshippedOrder);
        }
    }
}
