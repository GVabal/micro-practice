package dev.vabalas.warehouseservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("shoppingservices")
public interface ShoppingClient {
    @PostMapping("orders/complete/{id}")
    void completeOrder(@PathVariable Long id);
}
