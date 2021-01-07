package dev.vabalas.postofficeservices;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PARCELS")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "RECIPIENT")
    private String recipient;
    @Column(name = "ORDER_ID")
    private Long orderId;

    public Parcel(String recipient, Long orderId) {
        this.recipient = recipient;
        this.orderId = orderId;
    }
}
