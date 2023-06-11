package com.realtime.seatspringbootbackend.src.admin.dao;

import com.realtime.seatspringbootbackend.src.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}