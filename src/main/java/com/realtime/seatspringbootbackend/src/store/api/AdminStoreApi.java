package com.realtime.seatspringbootbackend.src.store.api;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreCreateRequestDTO;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreMemoRequestDTO;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreUpdateRequestDTO;
import com.realtime.seatspringbootbackend.src.store.dto.response.StoreMemoResponseDTO;
import com.realtime.seatspringbootbackend.src.store.exception.StoreInactiveException;
import com.realtime.seatspringbootbackend.src.store.exception.StoreNotFoundException;
import com.realtime.seatspringbootbackend.src.store.service.AdminStoreService;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/store")
@RequiredArgsConstructor
@Slf4j
public class AdminStoreApi {

    private final AdminStoreService adminStoreService;

    @Operation(summary = "어드민 가게 정보 가져오기")
    @GetMapping("/{id}") // TODO user id로 받는지?
    public ResponseEntity<StoreEntity> getStore(@PathVariable Long id) {
        try {
            StoreEntity storeEntity = adminStoreService.findById(id);
            return new ResponseEntity<>(storeEntity, HttpStatus.OK); // TODO dto 반환으로 바꾸기
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 정보 등록하기")
    @PostMapping
    public void postStore(@RequestBody @Valid StoreCreateRequestDTO storeCreateRequestDto) {
        try {
            adminStoreService.save(storeCreateRequestDto);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 정보 수정하기")
    @PatchMapping("/{id}")
    public void updateStore(
            @PathVariable Long id, @RequestBody StoreUpdateRequestDTO storeUpdateRequestDto) {
        try {
            adminStoreService.update(id, storeUpdateRequestDto);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 정보 삭제하기")
    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        try {
            adminStoreService.delete(id);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 메모 가져오기")
    @GetMapping("/memo/{id}")
    public ResponseEntity<StoreMemoResponseDTO> getStoreMemo(@PathVariable Long id) {
        try {
            StoreEntity storeEntity = adminStoreService.findById(id);
            return new ResponseEntity<>(
                    new StoreMemoResponseDTO(storeEntity.getMemo()), HttpStatus.OK);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 메모 등록하기")
    @PostMapping("/memo/{id}")
    public void postStoreMemo(
            @PathVariable Long id, @RequestBody StoreMemoRequestDTO storeMemoRequestDto) {
        try {
            adminStoreService.updateMemo(id, storeMemoRequestDto);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 메모 수정하기")
    @PatchMapping("/memo/{id}")
    public void updateMemo(
            @PathVariable Long id, @RequestBody StoreMemoRequestDTO storeMemoRequestDto) {
        try {
            adminStoreService.updateMemo(id, storeMemoRequestDto);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @Operation(summary = "어드민 가게 메모 삭제학기")
    @DeleteMapping("/memo/{id}")
    public void deleteStoreMemo(@PathVariable Long id) {
        try {
            adminStoreService.deleteMemo(id);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (StoreInactiveException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }
}
