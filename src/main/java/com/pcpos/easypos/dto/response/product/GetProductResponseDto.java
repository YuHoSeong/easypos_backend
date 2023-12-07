package com.pcpos.easypos.dto.response.product;

import java.time.LocalDateTime;

import com.pcpos.easypos.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponseDto {
    private Integer productIdx;
    private Integer categoryIdx;
    private Integer storeIdx;
    private String productName;
    private Integer price;
    private Boolean state;
    private LocalDateTime createdAt;

    public GetProductResponseDto(ProductEntity productEntity){
        this.productIdx = productEntity.getProductIdx();
        this.categoryIdx = productEntity.getCategoryIdx();
        this.storeIdx = productEntity.getStoreIdx();
        this.productName = productEntity.getProductName();
        this.price = productEntity.getPrice();
        this.state = productEntity.isState();
        this.createdAt = productEntity.getCreatedAt();

    }
}
