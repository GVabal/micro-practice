package dev.vabalas.factoryservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("warehouseservices")
public interface WarehouseClient {
    @PostMapping("inventory/do")
    void doThing(@RequestBody ThingDto thingDto);
}
