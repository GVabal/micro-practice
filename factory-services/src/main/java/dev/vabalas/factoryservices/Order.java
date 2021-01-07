package dev.vabalas.factoryservices;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String thingName;
    private Integer amount;
    private boolean isHandled;

    public Order(String thingName, Integer amount) {
        this.thingName = thingName;
        this.amount = amount;
        this.isHandled = false;
    }
}
