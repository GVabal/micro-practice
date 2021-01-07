package dev.vabalas.postofficeservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParcelDto {
    private String recipient;
    private Long orderId;

    @JsonCreator
    public ParcelDto(@JsonProperty String recipient, @JsonProperty Long orderId) {
        this.recipient = recipient;
        this.orderId = orderId;
    }

    public Parcel toParcel() {
        return new Parcel(recipient, orderId);
    }
}
