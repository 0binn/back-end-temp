package com.realtime.seatspringbootbackend.src.store.dto.response;

import com.realtime.seatspringbootbackend.src.store.domain.KindEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class StoreResponseDTO {

    private String name;
    private String introduction;
    private String location;
    private String mainImage;
}
