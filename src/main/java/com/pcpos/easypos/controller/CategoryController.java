package com.pcpos.easypos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcpos.easypos.common.constants.ApiPattern;
import com.pcpos.easypos.dto.request.category.PatchCategoryDto;
import com.pcpos.easypos.dto.request.category.PostCategoryDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.category.DeleteCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.GetCategoryListResponseDto;
import com.pcpos.easypos.dto.response.category.PatchCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.PostCategoryResponseDto;
import com.pcpos.easypos.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPattern.CATEGORY)
@Slf4j
public class CategoryController {

    @Autowired private CategoryService categoryService;

    private final String GET_CATEGORY = "/{storeIdx}";
    private final String POST_CATEGORY = "/";
    private final String PATCH_CATEGORY = "/";
    private final String DELETE_CATEGORY = "/{categoryIdx}";

    // 카테고리 리스트 조회
    @GetMapping(GET_CATEGORY)
    public ResponseDto<List<GetCategoryListResponseDto>> getCategoryList(@PathVariable Integer storeIdx){
        log.info("getCategory");
        ResponseDto<List<GetCategoryListResponseDto>> response = categoryService.getCategoryList(storeIdx);
        return response;
    }

    // 카테고리 등록
    @PostMapping(POST_CATEGORY)
    public ResponseDto<PostCategoryResponseDto> postCategory(@RequestBody PostCategoryDto dto){
        log.info("postCategory");
        ResponseDto<PostCategoryResponseDto> response = categoryService.postCategory(dto);
        return response;
    }

    // 카테고리 수정
    @PatchMapping(PATCH_CATEGORY)
    public ResponseDto<PatchCategoryResponseDto> patchCategory(@RequestBody PatchCategoryDto dto){
        log.info("patchCategory");
        ResponseDto<PatchCategoryResponseDto> response = categoryService.patchCategory(dto);
        return response;
    }

    // 카테고리 삭제
    @DeleteMapping(DELETE_CATEGORY)
    public ResponseDto<DeleteCategoryResponseDto> deleteCategory(@PathVariable Integer categoryIdx){
        log.info("deleteCategory");
        ResponseDto<DeleteCategoryResponseDto> response = categoryService.deleteCategory(categoryIdx);
        return response;
    }
}
