package com.realtime.seatspringbootbackend.src.store.repository;

import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.src.store.domain.CategoryEnum;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    List<StoreEntity> findAllByState(BaseEntity.State state);

    List<StoreEntity> findAllByStateAndCategory(BaseEntity.State state, CategoryEnum category);

    @Query("SELECT s FROM StoreEntity s WHERE s.name LIKE %:name%")
    List<StoreEntity> findByNameLike(@Param("name") String name);
}
