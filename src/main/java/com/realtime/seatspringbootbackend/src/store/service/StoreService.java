package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.common.utils.EnumUtils;
import com.realtime.seatspringbootbackend.src.store.domain.CategoryEnum;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.StoreMapper;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;
import com.realtime.seatspringbootbackend.src.store.exception.StoreCategoryNotFoundException;
import com.realtime.seatspringbootbackend.src.store.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<StoreResponseDTO> findAll(String category) throws Exception {
        if (category.equals(CategoryEnum.NONE.toString())) {
            List<StoreEntity> storeEntityList =
                    storeRepository.findAllByState(BaseEntity.State.ACTIVE);
            return StoreMapper.toDTOList(storeEntityList);
        } else {
            try {
                CategoryEnum enumFromString =
                        EnumUtils.getEnumFromString(category, CategoryEnum.class);
                List<StoreEntity> storeEntityList =
                        storeRepository.findAllByStateAndCategory(
                                BaseEntity.State.ACTIVE, enumFromString);
                return StoreMapper.toDTOList(storeEntityList);
            } catch (IllegalArgumentException e) {
                throw new StoreCategoryNotFoundException(ResponseCode.STORE_CATEGORY_NOT_FOUND);
            }
        }
    }

    public List<StoreResponseDTO> findAllByName(String name) {
        List<StoreEntity> storeEntityList = storeRepository.findByNameLike(name);
        return StoreMapper.toDTOList(storeEntityList);
    }
}
