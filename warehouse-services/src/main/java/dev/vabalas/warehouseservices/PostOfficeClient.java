package dev.vabalas.warehouseservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("postofficeservices")
public interface PostOfficeClient {
    @PostMapping("parcels")
    void sendParcel(@RequestBody ParcelDto parcelDto);
}
