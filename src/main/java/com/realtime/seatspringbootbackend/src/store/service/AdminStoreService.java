package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.common.utils.EnumUtils;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreCreateRequestDTO;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreMemoRequestDTO;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreUpdateRequestDTO;
import com.realtime.seatspringbootbackend.src.store.exception.StoreInactiveException;
import com.realtime.seatspringbootbackend.src.store.exception.StoreNotFoundException;
import com.realtime.seatspringbootbackend.src.store.repository.StoreRepository;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminStoreService {

    private final StoreRepository storeRepository;

    public StoreEntity findById(Long id) throws Exception {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        if (storeEntity.getState() == BaseEntity.State.INACTIVE)
            throw new StoreInactiveException(ResponseCode.STORE_INACTIVE);
        return storeEntity;
    }

    @Transactional
    public void save(StoreCreateRequestDTO storeCreateRequestDto) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setName(storeCreateRequestDto.getName());
        storeEntity.setIntroduction(storeCreateRequestDto.getIntroduction());
        storeEntity.setLocation(storeCreateRequestDto.getLocation());
        storeEntity.setTotalFloor(storeEntity.getTotalFloor());
        storeEntity.setKind(storeCreateRequestDto.getKind());
        storeEntity.setDayOff(EnumUtils.getEnumListAsString(storeCreateRequestDto.getDayOff()));
        storeEntity.setMonBusinessHours(storeCreateRequestDto.getMonBusinessHours());
        storeEntity.setTueBusinessHours(storeCreateRequestDto.getTueBusinessHours());
        storeEntity.setWedBusinessHours(storeCreateRequestDto.getWedBusinessHours());
        storeEntity.setThuBusinessHours(storeCreateRequestDto.getThuBusinessHours());
        storeEntity.setFriBusinessHours(storeCreateRequestDto.getFriBusinessHours());
        storeEntity.setSunBusinessHours(storeCreateRequestDto.getSunBusinessHours());
        storeEntity.setBreakTime(storeCreateRequestDto.getBreakTime());
        storeEntity.setUseTimeLimit(storeCreateRequestDto.getUseTimeLimit());
        storeRepository.save(storeEntity);
    }

    @Transactional
    public void update(Long id, StoreUpdateRequestDTO storeUpdateRequestDto) throws Exception {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        if (storeEntity.getState() == BaseEntity.State.INACTIVE)
            throw new StoreInactiveException(ResponseCode.STORE_INACTIVE);
        storeEntity.setName(storeUpdateRequestDto.getName());
        storeEntity.setIntroduction(storeUpdateRequestDto.getIntroduction());
        storeEntity.setLocation(storeUpdateRequestDto.getLocation());
        storeEntity.setTotalFloor(storeEntity.getTotalFloor());
        storeEntity.setKind(storeUpdateRequestDto.getKind());
        storeEntity.setDayOff(EnumUtils.getEnumListAsString(storeUpdateRequestDto.getDayOff()));
        storeEntity.setMonBusinessHours(storeUpdateRequestDto.getMonBusinessHours());
        storeEntity.setTueBusinessHours(storeUpdateRequestDto.getTueBusinessHours());
        storeEntity.setWedBusinessHours(storeUpdateRequestDto.getWedBusinessHours());
        storeEntity.setThuBusinessHours(storeUpdateRequestDto.getThuBusinessHours());
        storeEntity.setFriBusinessHours(storeUpdateRequestDto.getFriBusinessHours());
        storeEntity.setSunBusinessHours(storeUpdateRequestDto.getSunBusinessHours());
        storeEntity.setBreakTime(storeUpdateRequestDto.getBreakTime());
        storeEntity.setUseTimeLimit(storeUpdateRequestDto.getUseTimeLimit());
    }

    @Transactional
    public void delete(Long id) throws Exception {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        if (storeEntity.getState() == BaseEntity.State.INACTIVE)
            throw new StoreInactiveException(ResponseCode.STORE_INACTIVE);
        storeEntity.setState(BaseEntity.State.INACTIVE);
    }

    @Transactional
    public void updateMemo(Long id, StoreMemoRequestDTO storeMemoRequestDto) throws Exception {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        if (storeEntity.getState() == BaseEntity.State.INACTIVE)
            throw new StoreInactiveException(ResponseCode.STORE_INACTIVE);
        storeEntity.setMemo(storeMemoRequestDto.getMemo());
    }

    @Transactional
    public void deleteMemo(Long id) throws Exception {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        if (storeEntity.getState() == BaseEntity.State.INACTIVE)
            throw new StoreInactiveException(ResponseCode.STORE_INACTIVE);
        storeEntity.setMemo(null);
    }
}
