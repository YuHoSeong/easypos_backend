package com.pcpos.easypos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpos.easypos.common.constants.ResponseMessage;
import com.pcpos.easypos.dto.request.category.PatchCategoryDto;
import com.pcpos.easypos.dto.request.category.PostCategoryDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.category.DeleteCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.GetCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.PatchCategoryResponseDto;
import com.pcpos.easypos.dto.response.category.PostCategoryResponseDto;
import com.pcpos.easypos.entity.CategoryEntity;
import com.pcpos.easypos.repository.CategoryRepository;
import com.pcpos.easypos.service.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired private CategoryRepository categoryRepository; 

    // 카테고리 조회
    @Override
    public ResponseDto<List<GetCategoryResponseDto>> getCategory(Integer storeIdx) {
        List<GetCategoryResponseDto> data = null;

        try {
            List<CategoryEntity> categoryEntities = categoryRepository.findByStoreIdxOrderByPriorityDesc(storeIdx);
            if(categoryEntities == null) ResponseDto.setFailed(ResponseMessage.NOT_EXIST_CATEGORY);

            data = GetCategoryResponseDto.copyList(categoryEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 카테고리 등록
    @Override
    public ResponseDto<PostCategoryResponseDto> postCategory(PostCategoryDto dto) {
        PostCategoryResponseDto data = null;

        try {
            CategoryEntity categoryEntity = new CategoryEntity(dto);
            categoryRepository.save(categoryEntity);

            data = new PostCategoryResponseDto(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // todo 카테고리 순서 수정하는 아이디어 : categoryIdx를 List로 받아서 순서대로 priority를 다시 저장한다. List<CategoryEntity>에 담아서 saveAll로 한번에 할것.
    // 카테고리 수정
    @Override
    public ResponseDto<PatchCategoryResponseDto> patchCategory(PatchCategoryDto dto) {
        PatchCategoryResponseDto data = null;
        Integer categoryIdx = dto.getCategoryIdx();

        try {
            CategoryEntity categoryEntity = categoryRepository.findById(categoryIdx).orElseThrow();
            categoryEntity.patchCategory(dto);

            categoryRepository.save(categoryEntity);
            data = new PatchCategoryResponseDto(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 카테고리 삭제
    @Override
    @Transactional
    public ResponseDto<DeleteCategoryResponseDto> deleteCategory(Integer categoryIdx) {
        DeleteCategoryResponseDto data = null;

        try {
            if(!categoryRepository.existsById(categoryIdx)) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_CATEGORY);
            categoryRepository.deleteById(categoryIdx);
            data = new DeleteCategoryResponseDto(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
