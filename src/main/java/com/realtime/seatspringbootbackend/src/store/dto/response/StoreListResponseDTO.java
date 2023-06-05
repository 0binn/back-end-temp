package com.realtime.seatspringbootbackend.src.store.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StoreListResponseDTO {

    private int count;
    private List<StoreResponseDTO> storeList;
}
