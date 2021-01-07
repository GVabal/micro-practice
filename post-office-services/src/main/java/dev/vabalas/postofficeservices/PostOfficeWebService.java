package dev.vabalas.postofficeservices;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("parcels")
public class PostOfficeWebService {
    private final ParcelRepository parcelRepository;

    @GetMapping
    Iterable<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Parcel receiveParcel(@RequestBody ParcelDto parcelDto) {
        return parcelRepository.save(parcelDto.toParcel());
    }
}
