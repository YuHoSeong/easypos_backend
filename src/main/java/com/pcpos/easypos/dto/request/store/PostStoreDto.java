package com.pcpos.easypos.dto.request.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostStoreDto {
    private String storeName;
    private Integer openTime;
    private Integer closeTime;
}
