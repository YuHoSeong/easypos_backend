package com.pcpos.easypos.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchProductDto {
    private Integer productIdx;
    private Integer categoryIdx;
    private String productName;
    private Integer price;
    private boolean state;
}
