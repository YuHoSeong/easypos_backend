package com.pcpos.easypos.dto.request.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchStoreDto {
    private Integer storeIdx;
    private String storeName;
    private Integer openTime;
    private Integer closeTime;
}
