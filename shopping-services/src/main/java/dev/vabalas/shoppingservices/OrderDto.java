package dev.vabalas.shoppingservices;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String customer;
    private Set<Thing> things;
}
