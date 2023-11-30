package com.pcpos.easypos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcpos.easypos.common.constants.ApiPattern;
import com.pcpos.easypos.dto.request.store.PatchStoreDto;
import com.pcpos.easypos.dto.request.store.PostStoreDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.store.DeleteStoreResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreListResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PatchStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PostStoreResponseDto;
import com.pcpos.easypos.service.StoreService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPattern.STORE)
@Slf4j
public class StoreController {
    
    @Autowired private StoreService storeService;

    private final String GET_STORE_LIST ="/";
    private final String GET_STORE ="/{storeIdx}";
    private final String POST_STORE ="/";
    private final String PATCH_STORE ="/";
    private final String DELETE_STORE ="/{storeIdx}";

    // 매장 전체 조회
    @GetMapping(GET_STORE_LIST)
    public ResponseDto<List<GetStoreListResponseDto>> getStoreList(@AuthenticationPrincipal String email){
        log.info("getStoreList");
        ResponseDto<List<GetStoreListResponseDto>> response = storeService.getStoreList(email);
        return response;
    }

    // 매장 상세 조회
    @GetMapping(GET_STORE)
    public ResponseDto<GetStoreResponseDto> getStore(@PathVariable Integer storeIdx){
        log.info("getStore");
        ResponseDto<GetStoreResponseDto> response = storeService.getStore(storeIdx);
        return response;
    }

    // 매장 등록
    @PostMapping(POST_STORE)
    public ResponseDto<PostStoreResponseDto> postStore(@AuthenticationPrincipal String email, @RequestBody PostStoreDto requestBody){
        log.info("postStore");
        ResponseDto<PostStoreResponseDto> response = storeService.postStore(email, requestBody);
        return response;
    }

    // 매장 수정
    @PatchMapping(PATCH_STORE)
    public ResponseDto<PatchStoreResponseDto> patchStore(@RequestBody PatchStoreDto requestBody){
        log.info("patchStore");
        ResponseDto<PatchStoreResponseDto> response = storeService.patchStore(requestBody);
        return response;
    }
    
    // 매장 삭제
    @DeleteMapping(DELETE_STORE)
    public ResponseDto<DeleteStoreResponseDto> deleteStore(@PathVariable Integer storeIdx){
        log.info("deleteStore");
        ResponseDto<DeleteStoreResponseDto> response = storeService.deleteStore(storeIdx);
        return response;
    }
}
