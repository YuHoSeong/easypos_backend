package com.pcpos.easypos.dto.response.store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pcpos.easypos.entity.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetStoreListResponseDto {
    private Integer storeIdx;
    private String storeName;
    private Integer openTime;
    private Integer closeTime;
    private LocalDateTime createdAt;
    // todo storeImage 어떻게 할것인지

    public GetStoreListResponseDto(StoreEntity storeEntity){
        this.storeIdx = storeEntity.getStoreIdx();
        this.storeName = storeEntity.getStoreName();
        this.openTime = storeEntity.getOpenTime();
        this.closeTime = storeEntity.getCloseTime();
        this.createdAt = storeEntity.getCreatedAt();
    }

    public static List<GetStoreListResponseDto> copyList(List<StoreEntity> storeEntities){
        List<GetStoreListResponseDto> list = new ArrayList<>();
        for(StoreEntity storeEntity :storeEntities){
            list.add(new GetStoreListResponseDto(storeEntity));
        }
        return list;
    }
}
