package com.pcpos.easypos.dto.response.category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pcpos.easypos.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryListResponseDto {
    private Integer categoryIdx;
    private String categoryName;
    private Integer priority;
    private LocalDateTime createdAt;

    public GetCategoryListResponseDto(CategoryEntity categoryEntity){
        this.categoryIdx = categoryEntity.getCategoryIdx();
        this.categoryName = categoryEntity.getCategoryName();
        this.priority = categoryEntity.getPriority();
        this.createdAt = categoryEntity.getCreatedAt();
    }

    public static List<GetCategoryListResponseDto> copyList(List<CategoryEntity> categoryEntities){
        List<GetCategoryListResponseDto> list = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryEntities){
            list.add(new GetCategoryListResponseDto(categoryEntity));
        }
        return list;
    }
}
