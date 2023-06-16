package com.realtime.seatspringbootbackend.src.admin.service;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.admin.dao.AdminInfoRepository;
import com.realtime.seatspringbootbackend.src.admin.dao.AdminRepository;
import com.realtime.seatspringbootbackend.src.admin.domain.AdminInfoEntity;
import com.realtime.seatspringbootbackend.src.admin.dto.request.AdminSignUpRequestDTO;
import com.realtime.seatspringbootbackend.src.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminSignUpService {

    private final AdminRepository adminRepository;
    private final AdminInfoRepository adminInfoRepository;

    public void save(User user) {adminRepository.save(user);}
    public void save(AdminInfoEntity adminInfoEntity){adminInfoRepository.save(adminInfoEntity);}

    public void checkPassword(AdminSignUpRequestDTO adminSignUpRequestDTO) {

        if(!adminSignUpRequestDTO.getPassword().equals(adminSignUpRequestDTO.getPasswordChecked())) {
            throw new BaseException(ResponseCode.SIGN_UP_PASSWORD_CHECK_FAIL);
        }
    }

}