package com.realtime.seatspringbootbackend.src.store.dto.response;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreResponseDTO {

    private String name;
    private String introduction;
    private String location;
    private String mainImage;
}
