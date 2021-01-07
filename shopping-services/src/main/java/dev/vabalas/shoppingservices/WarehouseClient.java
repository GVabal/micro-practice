package dev.vabalas.shoppingservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("warehouseservices")
public interface WarehouseClient {
    @PostMapping("inventory")
    void handleOrderRequest(@RequestBody OrderDto orderDto);
}
