package com.pcpos.easypos.service;

import java.util.List;

import com.pcpos.easypos.dto.request.store.PatchStoreDto;
import com.pcpos.easypos.dto.request.store.PostStoreDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.store.DeleteStoreResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreListResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PatchStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PostStoreResponseDto;

public interface StoreService {
    // 매장 전체 조회
    public ResponseDto<List<GetStoreListResponseDto>> getStoreList(String email);
    // 매장 상세 조회
    public ResponseDto<GetStoreResponseDto> getStore(Integer storeIdx);
    // 매장 등록
    public ResponseDto<PostStoreResponseDto> postStore(String email, PostStoreDto dto);
    // 매장 수정
    public ResponseDto<PatchStoreResponseDto> patchStore(PatchStoreDto dto);
    // 매장 삭제
    public ResponseDto<DeleteStoreResponseDto> deleteStore(Integer storeIdx);
}
