package dev.vabalas.factoryservices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThingDto {
    private String name;
    private Integer qty;
}
