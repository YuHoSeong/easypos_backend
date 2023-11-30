package com.pcpos.easypos.entity;

import java.time.LocalDateTime;

import com.pcpos.easypos.dto.request.store.PatchStoreDto;
import com.pcpos.easypos.dto.request.store.PostStoreDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Store")
@Table(name = "Store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeIdx;
    private Integer userIdx;
    private String storeName;
    private Integer openTime;
    private Integer closeTime;
    private LocalDateTime createdAt;

    public StoreEntity(Integer userIdx, PostStoreDto dto){
        this.userIdx = userIdx;
        this.storeName = dto.getStoreName();
        this.openTime = dto.getOpenTime();
        this.closeTime = dto.getCloseTime();
        this.createdAt = LocalDateTime.now();
    }

    public void patchStore(PatchStoreDto dto){
        this.storeName = dto.getStoreName();
        this.openTime = dto.getOpenTime();
        this.closeTime = dto.getCloseTime();

    }

}
