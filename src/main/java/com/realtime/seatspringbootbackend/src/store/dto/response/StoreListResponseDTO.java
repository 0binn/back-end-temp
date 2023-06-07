package com.realtime.seatspringbootbackend.src.store.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StoreListResponseDTO {

    private int curCount;
    private int curPage;
    private long totalCount;
    private int totalPage;
    private List<StoreResponseDTO> storeList;
}
