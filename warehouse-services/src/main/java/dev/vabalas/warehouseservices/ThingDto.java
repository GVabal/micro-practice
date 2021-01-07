package dev.vabalas.warehouseservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThingDto {
    private String name;
    private Integer qty;

    @JsonCreator
    public ThingDto(@JsonProperty String name, @JsonProperty Integer qty) {
        this.name = name;
        this.qty = qty;
    }
}
