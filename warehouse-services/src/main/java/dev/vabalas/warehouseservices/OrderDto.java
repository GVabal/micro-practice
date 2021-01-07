package dev.vabalas.warehouseservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDto {
    private Long id;
    private String customer;
    private Set<Thing> things;

    @JsonCreator
    public OrderDto(@JsonProperty Long id,
                    @JsonProperty String customer,
                    @JsonProperty Set<Thing> things) {
        this.id = id;
        this.customer = customer;
        this.things = things;
    }
}
