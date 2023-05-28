package com.realtime.seatspringbootbackend.src.store.repository;

import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    List<StoreEntity> findAllByState(BaseEntity.State state);
}
