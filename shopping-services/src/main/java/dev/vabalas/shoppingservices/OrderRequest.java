package dev.vabalas.shoppingservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class OrderRequest {
    private String customer;
    private Set<Thing> things;

    @JsonCreator
    public OrderRequest(@JsonProperty String customer, @JsonProperty Set<Thing> things) {
        this.customer = customer;
        this.things = things;
    }

    public Order toOrder() {
        return new Order(customer, things);
    }
}
