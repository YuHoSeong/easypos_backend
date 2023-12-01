package com.pcpos.easypos.entity;

import java.time.LocalDateTime;

import com.pcpos.easypos.dto.request.category.PatchCategoryDto;
import com.pcpos.easypos.dto.request.category.PostCategoryDto;

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
@Table(name = "Category")
@Entity(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryIdx;
    private Integer storeIdx;
    private String categoryName;
    private Integer priority;
    private LocalDateTime createdAt;

    public CategoryEntity(PostCategoryDto dto){
        this.storeIdx = dto.getStoreIdx();
        this.categoryName = dto.getCategoryName();
        this.priority = dto.getPriority();
        this.createdAt = LocalDateTime.now();
    }

    public void patchCategory(PatchCategoryDto dto){
        this.categoryName = dto.getCategoryName();
        this.priority = dto.getPriority();
    }
}
