package com.realtime.seatspringbootbackend.src.admin.dao;

import com.realtime.seatspringbootbackend.src.admin.domain.AdminInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminInfoRepository extends JpaRepository<AdminInfoEntity,Long> {
}
