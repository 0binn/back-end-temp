package com.realtime.seatspringbootbackend.src.store.api;

import com.amazonaws.Response;
import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;
import com.realtime.seatspringbootbackend.src.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/v1/users/stores")
@RequiredArgsConstructor
@Slf4j
public class StoreApi {

    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoreResponseDTO>> getStores() {
        try {
            List<StoreResponseDTO> storeResponseDTOList = storeService.findAll();
            return new ResponseEntity<>(storeResponseDTOList, HttpStatus.OK);
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }
}
