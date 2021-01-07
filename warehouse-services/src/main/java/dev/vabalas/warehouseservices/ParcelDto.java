package dev.vabalas.warehouseservices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParcelDto {
    private String recipient;
    private Long orderId;
}
