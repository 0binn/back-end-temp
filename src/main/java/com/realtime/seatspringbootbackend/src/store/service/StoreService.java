package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.StoreMapper;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;
import com.realtime.seatspringbootbackend.src.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<StoreResponseDTO> findAll() {
        List<StoreEntity> storeEntityList = storeRepository.findAllByState(BaseEntity.State.ACTIVE);
        return StoreMapper.toDTOList(storeEntityList);
    }

}
