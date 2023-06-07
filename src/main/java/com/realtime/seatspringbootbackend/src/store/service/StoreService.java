package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.common.utils.EnumUtils;
import com.realtime.seatspringbootbackend.src.store.domain.CategoryEnum;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.StoreMapper;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;
import com.realtime.seatspringbootbackend.src.store.exception.StoreCategoryNotFoundException;
import com.realtime.seatspringbootbackend.src.store.exception.StoreSortFieldNotFoundException;
import com.realtime.seatspringbootbackend.src.store.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {

    private final StoreRepository storeRepository;

    public Page<StoreResponseDTO> findAll(String category, Pageable pageable) throws Exception {
        try {
            for (Sort.Order order : pageable.getSort()) {
                String sortField = order.getProperty();
                StoreEntity.class.getDeclaredField(sortField);
            }
            if (category.equals(CategoryEnum.NONE.toString())) {
                Page<StoreEntity> storeEntityList =
                        storeRepository.findAllByState(BaseEntity.State.ACTIVE, pageable);
                return StoreMapper.toDTOPageList(storeEntityList);
            } else {
                CategoryEnum enumFromString =
                        EnumUtils.getEnumFromString(category, CategoryEnum.class);
                Page<StoreEntity> storeEntityList =
                        storeRepository.findAllByStateAndCategory(
                                BaseEntity.State.ACTIVE, enumFromString, pageable);
                return StoreMapper.toDTOPageList(storeEntityList);
            }
        } catch (NoSuchFieldException e) {
            throw new StoreSortFieldNotFoundException(ResponseCode.STORE_SORT_FIELD_NOT_FOUND);
        } catch (IllegalArgumentException e) {
            throw new StoreCategoryNotFoundException(ResponseCode.STORE_CATEGORY_NOT_FOUND);
        }
    }

    public List<StoreResponseDTO> findAllByName(String name) {
        List<StoreEntity> storeEntityList = storeRepository.findByNameLike(name);
        return StoreMapper.toDTOList(storeEntityList);
    }
}
