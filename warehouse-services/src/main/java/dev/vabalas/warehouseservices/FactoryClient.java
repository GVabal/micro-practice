package dev.vabalas.warehouseservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("factoryservices")
public interface FactoryClient {
    @PostMapping("take-order")
    void makeSingleThingOrder(@RequestParam String name, @RequestParam Integer qty);
}
