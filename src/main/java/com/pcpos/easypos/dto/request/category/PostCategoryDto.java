package com.pcpos.easypos.dto.request.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCategoryDto {
    private Integer storeIdx;
    private String categoryName;
    private Integer priority;
}
