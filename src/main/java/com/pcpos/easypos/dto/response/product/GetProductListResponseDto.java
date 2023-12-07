package com.pcpos.easypos.dto.response.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pcpos.easypos.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductListResponseDto {
    private Integer productIdx;
    private Integer categoryIdx;
    private Integer storeIdx;
    private String productName;
    private Integer price;
    private Boolean state;
    private LocalDateTime createdAt;

    public GetProductListResponseDto(ProductEntity productEntity){
        this.productIdx = productEntity.getProductIdx();
        this.categoryIdx = productEntity.getCategoryIdx();
        this.storeIdx = productEntity.getStoreIdx();
        this.productName = productEntity.getProductName();
        this.price = productEntity.getPrice();
        this.state = productEntity.isState();
        this.createdAt = productEntity.getCreatedAt();
    }

    public static List<GetProductListResponseDto> copyList(List<ProductEntity> productEntities){
        List<GetProductListResponseDto> list = new ArrayList<>();
        for(ProductEntity productEntity : productEntities){
            list.add(new GetProductListResponseDto(productEntity));
        }
        return list;
    }
}
