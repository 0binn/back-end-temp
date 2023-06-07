package com.realtime.seatspringbootbackend.src.store.api;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreListResponseDTO;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreResponseDTO;
import com.realtime.seatspringbootbackend.src.store.exception.StoreCategoryNotFoundException;
import com.realtime.seatspringbootbackend.src.store.exception.StoreSortFieldNotFoundException;
import com.realtime.seatspringbootbackend.src.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                            schema =
                                    @Schema(
                                            allowableValues = {
                                                "NONE",
                                                "RESTAURANT",
                                                "CAFE",
                                                "SPACE"
                                            }))
                    @RequestParam(defaultValue = "NONE")
                    String category,
            @Parameter(
                            description =
                                    "page - 1부터 시작, size - 한 페이지에 담을 데이터 수, sort - 정렬 조건, 순서대로 적용",
                            name = "pageable",
                            required = true)
                    Pageable pageable) {
        try {
            Page<StoreResponseDTO> storeResponseDTOList = storeService.findAll(category, pageable);
            return new ResponseEntity<>(
                    StoreListResponseDTO.builder()
                            .curCount(storeResponseDTOList.getNumberOfElements())
                            .curPage(pageable.getPageNumber() + 1)
                            .totalCount(storeResponseDTOList.getTotalElements())
                            .totalPage(storeResponseDTOList.getTotalPages())
                            .storeList(storeResponseDTOList.getContent())
                            .build(),
                    HttpStatus.OK);
        } catch (StoreCategoryNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreSortFieldNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            log.info(Arrays.toString(e.getStackTrace()));
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "가게 이름으로 검색하기")
    @GetMapping("/list/name")
    public ResponseEntity<StoreListResponseDTO> getStoresByName(
            @Parameter(description = "가게의 이름을 포함하는 결과 검색", name = "name", required = true)
                    @RequestParam
                    String name) {
        try {
            List<StoreResponseDTO> storeResponseDTOList = storeService.findAllByName(name);
            return new ResponseEntity<>(
                    StoreListResponseDTO.builder()
                            .storeList(storeResponseDTOList)
                            .totalCount(storeResponseDTOList.size())
                            .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }
}
