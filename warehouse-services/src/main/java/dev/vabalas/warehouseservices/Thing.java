package dev.vabalas.warehouseservices;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INVENTORY")
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THING_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "QTY")
    private Integer qty;

    public Thing(String name, Integer qty) {
        this.name = name;
        this.qty = qty;
    }
}
