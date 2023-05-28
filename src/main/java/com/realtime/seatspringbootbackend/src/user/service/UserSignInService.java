package com.realtime.seatspringbootbackend.src.user.service;

import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.src.user.dao.UserRepository;
import com.realtime.seatspringbootbackend.src.user.dto.request.UserSignInReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSignInService {
    private final UserRepository userRepository;

    public void userSignIn(UserSignInReq userSignInReq) {}

    public boolean isExistEmail(String email) {
        return userRepository.existsByEmailAndState(email, BaseEntity.State.ACTIVE);
    }
}
