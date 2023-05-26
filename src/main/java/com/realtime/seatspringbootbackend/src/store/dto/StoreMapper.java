package com.realtime.seatspringbootbackend.src.store.dto;

import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class StoreMapper {

    public static StoreResponseDTO toDTO(StoreEntity storeEntity) {
        StoreResponseDTO storeResponseDTO = new StoreResponseDTO();
        storeResponseDTO.setName(storeEntity.getName());
        storeResponseDTO.setIntroduction(storeEntity.getIntroduction());
        storeResponseDTO.setMainImage(storeEntity.getMainImage());
        storeResponseDTO.setLocation(storeEntity.getLocation());
        return storeResponseDTO;
    }

    public static List<StoreResponseDTO> toDTOList(List<StoreEntity> storeEntityList) {
        List<StoreResponseDTO> dtoList = new ArrayList<>();
        for (StoreEntity storeEntity : storeEntityList) {
            dtoList.add(toDTO(storeEntity));
        }
        return dtoList;
    }
}
