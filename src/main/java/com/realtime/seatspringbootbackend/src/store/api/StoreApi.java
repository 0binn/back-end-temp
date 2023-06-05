package com.realtime.seatspringbootbackend.src.store.api;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreListResponseDTO;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;
import com.realtime.seatspringbootbackend.src.store.exception.StoreCategoryNotFoundException;
import com.realtime.seatspringbootbackend.src.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/stores")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "02. [Store - Users]")
public class StoreApi {

    private final StoreService storeService;

    @Operation(summary = "리스트 페이지에서 가게 정보 받아오기")
    @GetMapping("/list")
    public ResponseEntity<StoreListResponseDTO> getStores(
            @Parameter(
                            description = "가게의 카테고리(NONE - 생략 가능, 전체 & 나머지 - 특정 카테고리)",
                            name = "category",
                            required = true,
                            schema = @Schema(allowableValues = {"NONE", "RESTAURANT", "CAFE", "SPACE"}))
                    @RequestParam(defaultValue = "NONE")
                    String category) {
        try {
            List<StoreResponseDTO> storeResponseDTOList = storeService.findAll(category);
            return new ResponseEntity<>(
                    new StoreListResponseDTO(storeResponseDTOList.size(), storeResponseDTOList),
                    HttpStatus.OK);
        } catch (StoreCategoryNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }
}
