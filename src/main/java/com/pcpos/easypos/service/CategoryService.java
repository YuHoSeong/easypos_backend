package com.pcpos.easypos.service;

import java.util.List;

import com.pcpos.easypos.dto.request.category.PatchCategoryDto;
import com.pcpos.easypos.dto.request.category.PostCategoryDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.category.DeleteCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.GetCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.PatchCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.PostCategoryResponseDto;

public interface CategoryService {
    // 카테고리 조회
    public ResponseDto<List<GetCategoryResponseDto>> getCategory(Integer storeIdx);
    // 카테고리 등록
    public ResponseDto<PostCategoryResponseDto> postCategory(PostCategoryDto dto);
    // 카테고리 수정
    public ResponseDto<PatchCategoryResponseDto> patchCategory(PatchCategoryDto dto);
    // 카테고리 삭제
    public ResponseDto<DeleteCategoryResponseDto> deleteCategory(Integer categoryIdx);
}
