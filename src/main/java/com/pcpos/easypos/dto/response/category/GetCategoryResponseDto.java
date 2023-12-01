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
public class GetCategoryResponseDto {
    private Integer categoryIdx;
    private String categoryName;
    private Integer priority;
    private LocalDateTime createdAt;

    public static List<GetCategoryResponseDto> copyList(List<CategoryEntity> categoryEntities){
        List<GetCategoryResponseDto> list = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryEntities){
            list.add(new GetCategoryResponseDto(
                categoryEntity.getCategoryIdx(),
                categoryEntity.getCategoryName(),
                categoryEntity.getPriority(),
                categoryEntity.getCreatedAt())
            );
        }
        return list;
    }
}
