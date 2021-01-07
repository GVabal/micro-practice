package dev.vabalas.shoppingservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name = "THINGS")
public class Thing {
    @Column(name = "NAME")
    private String name;
    @Column(name = "QTY")
    private Integer qty;
}
