package com.pcpos.easypos.dto.response.store;

import java.time.LocalDateTime;

import com.pcpos.easypos.entity.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetStoreResponseDto {
    private Integer storeIdx;
    private String storeName;
    private Integer openTime;
    private Integer closeTime;
    private LocalDateTime createdAt;

    public GetStoreResponseDto(StoreEntity storeEntity){
        this.storeIdx = storeEntity.getStoreIdx();
        this.storeName = storeEntity.getStoreName();
        this.openTime = storeEntity.getOpenTime();
        this.closeTime = storeEntity.getCloseTime();
        this.createdAt = storeEntity.getCreatedAt();
    }
}
