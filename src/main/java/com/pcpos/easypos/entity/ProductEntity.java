package com.pcpos.easypos.entity;

import java.time.LocalDateTime;

import com.pcpos.easypos.dto.request.product.PatchProductDto;
import com.pcpos.easypos.dto.request.product.PostProductDto;

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
@Entity(name = "Product")
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productIdx;
    private Integer categoryIdx;
    private Integer storeIdx;
    private String productName;
    private Integer price;
    private boolean state;
    private LocalDateTime createdAt;

    public ProductEntity(PostProductDto dto){
        this.categoryIdx = dto.getCategoryIdx();
        this.storeIdx = dto.getStoreIdx();
        this.productName = dto.getProductName();
        this.price = dto.getPrice();
        this.state = true;
        this.createdAt = LocalDateTime.now();

    }

    public void patchProduct(PatchProductDto dto){
        this.categoryIdx = dto.getCategoryIdx();
        this.productName = dto.getProductName();
        this.price = dto.getPrice();
        this.state = dto.isState();
    }
}
