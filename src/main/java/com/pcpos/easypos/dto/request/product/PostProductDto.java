package com.pcpos.easypos.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostProductDto {
    private Integer categoryIdx;
    private Integer storeIdx;
    private String productName;
    private Integer price;
}
