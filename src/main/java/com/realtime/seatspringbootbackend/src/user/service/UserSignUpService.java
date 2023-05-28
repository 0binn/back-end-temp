package com.realtime.seatspringbootbackend.src.user.service;

import static com.realtime.seatspringbootbackend.common.entity.BaseEntity.State.*;

import com.realtime.seatspringbootbackend.src.user.dao.UserAdaptor;
import com.realtime.seatspringbootbackend.src.user.dao.UserRepository;
import com.realtime.seatspringbootbackend.src.user.domain.User;
import com.realtime.seatspringbootbackend.src.user.domain.UserRole;
import com.realtime.seatspringbootbackend.src.user.dto.request.UserSignUpReq;
import com.realtime.seatspringbootbackend.src.user.dto.response.ValidateUserInformationRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserSignUpService {
    private final UserRepository userRepository;
    private final UserAdaptor userAdaptor;
    //    private final PasswordEncoder passwordEncoder;
    public ValidateUserInformationRes isNicknameDuplicated(String nickname) {
        return new ValidateUserInformationRes(
                !userRepository.existsByNicknameAndState(nickname, ACTIVE));
    }

    public ValidateUserInformationRes isEmailDuplicated(String email) {
        return new ValidateUserInformationRes(!userRepository.existsByEmailAndState(email, ACTIVE));
    }

    public void userSignUp(UserSignUpReq userSignUpReq) {
        User user =
                User.builder()
                        .email(userSignUpReq.getEmail())
                        .password(userSignUpReq.getPassword())
                        .role(UserRole.USER)
                        .employerIdNumber(null)
                        .age(userSignUpReq.getAge())
                        .nickname(userSignUpReq.getNickname())
                        .sex(userSignUpReq.getSex())
                        .consentToMarketing(userSignUpReq.getConsentToMarketing())
                        .consentToTermsOfUser(userSignUpReq.getConsentToTermsOfUser())
                        .build();
        userAdaptor.save(user);
    }
}
