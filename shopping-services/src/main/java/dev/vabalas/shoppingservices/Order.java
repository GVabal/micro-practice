package dev.vabalas.shoppingservices;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "CUSTOMER")
    private String customer;
    @Column(name = "IS_SHIPPED")
    private boolean isShipped;
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="ORDER_THINGS",
            joinColumns=@JoinColumn(name="ORDER_ID"))
    @Column(name = "THING")
    private Set<Thing> things;

    public Order(String customer, Set<Thing> things) {
        this.customer = customer;
        this.things = things;
    }
}
