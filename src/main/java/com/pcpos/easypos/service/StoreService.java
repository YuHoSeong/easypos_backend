package com.pcpos.easypos.service;

import java.util.List;

import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.store.DeleteStoreResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreListResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PatchStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PostStoreResponseDto;

public interface StoreService {
    // 매장 전체 조회(유저idx)
    public ResponseDto<List<GetStoreListResponseDto>> getStoreList(String Email);
    // 매장 상세 조회(매장idx)
    public ResponseDto<GetStoreResponseDto> getStore(String Email, GetStoreDto dto);
    // 매장 등록(매장dto)
    public ResponseDto<PostStoreResponseDto> postStore(String Email, PostStoreDto dto);
    // 매장 수정(매장dto)
    public ResponseDto<PatchStoreResponseDto> patchStore(String Email, PatchStoreDto dto);
    // 매장 삭제(매장idx)
    public ResponseDto<DeleteStoreResponseDto> deleteStore(String Email, DeleteStoreDto dto);
}
