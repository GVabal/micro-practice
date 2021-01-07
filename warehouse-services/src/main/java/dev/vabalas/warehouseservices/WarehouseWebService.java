package dev.vabalas.warehouseservices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("inventory")
public class WarehouseWebService {
    private final ThingRepository thingRepository;
    private final ShoppingClient shoppingClient;
    private final PostOfficeClient postOfficeClient;
    private final FactoryClient factoryClient;

    @GetMapping("init")
    void initSomeThings() {
        thingRepository.saveAll(List.of(
                new Thing("Shoe", 1000),
                new Thing("Fork", 1000),
                new Thing("Spoon", 1000),
                new Thing("Pant", 1000),
                new Thing("Puppy", 1000)
        ));
    }

    @GetMapping
    Iterable<Thing> getAllThings() {
        return thingRepository.findAll();
    }

    @PostMapping("do")
    Thing doThing(@RequestBody ThingDto thingDto) {
        return thingRepository.findByName(thingDto.getName()).map(thing -> {
            thing.setQty(thing.getQty() + thingDto.getQty());
            return thingRepository.save(thing);
        }).orElseGet(() ->
                thingRepository.save(new Thing(thingDto.getName(), thingDto.getQty())));
    }

    @PostMapping
    void handleOrderRequest(@RequestBody OrderDto orderDto) {
        List<Thing> thingsInStock = new ArrayList<>();
        boolean canHandleOrder = true;
        orderDto.getThings().forEach(thing -> thingsInStock.add(thingRepository.findByName(thing.getName()).get()));
        for (int i = 0; i < thingsInStock.size(); i++) {
            int finalI = i;
            if (thingsInStock.get(i).getQty() <=
                    orderDto.getThings().stream()
                            .filter(t -> t.getName().equals(thingsInStock.get(finalI).getName()))
                            .mapToInt(Thing::getQty).sum()) {
                canHandleOrder = false;
                factoryClient.makeSingleThingOrder(thingsInStock.get(i).getName(),
                        orderDto.getThings().stream()
                                .filter(t -> t.getName().equals(thingsInStock.get(finalI).getName()))
                                .mapToInt(Thing::getQty).sum());
            }
        }
        if (canHandleOrder) {
            shoppingClient.completeOrder(orderDto.getId());
            for (int i = 0; i < thingsInStock.size(); i++) {
                int finalI = i;
                thingsInStock.get(i).setQty(thingsInStock.get(i).getQty() - orderDto.getThings().stream()
                        .filter(t -> t.getName().equals(thingsInStock.get(finalI).getName()))
                        .mapToInt(Thing::getQty).sum());
            }
            thingRepository.saveAll(thingsInStock);
            postOfficeClient.sendParcel(new ParcelDto(orderDto.getCustomer(), orderDto.getId()));
        }
    }
}
