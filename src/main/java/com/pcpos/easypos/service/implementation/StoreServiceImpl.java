package com.pcpos.easypos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpos.easypos.common.constants.ResponseMessage;
import com.pcpos.easypos.dto.request.store.PatchStoreDto;
import com.pcpos.easypos.dto.request.store.PostStoreDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.store.DeleteStoreResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreListResponseDto;
import com.pcpos.easypos.dto.response.store.GetStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PatchStoreResponseDto;
import com.pcpos.easypos.dto.response.store.PostStoreResponseDto;
import com.pcpos.easypos.entity.StoreEntity;
import com.pcpos.easypos.repository.StoreRepository;
import com.pcpos.easypos.repository.UserRepository;
import com.pcpos.easypos.service.StoreService;

import jakarta.transaction.Transactional;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired private StoreRepository storeRepository;
    @Autowired private UserRepository userRepository;

    // 매장 전체 조회
    @Override
    public ResponseDto<List<GetStoreListResponseDto>> getStoreList(String email) {
        List<GetStoreListResponseDto> data = null;

        try {
            List<StoreEntity> storeEntities = storeRepository.findByEmail(email);
            data = GetStoreListResponseDto.copyList(storeEntities);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 매장 상세 조회
    @Override
    public ResponseDto<GetStoreResponseDto> getStore(Integer storeIdx) {
        GetStoreResponseDto data = null;

        try {
            StoreEntity storeEntity = storeRepository.findById(storeIdx).orElseThrow();
            data = new GetStoreResponseDto(storeEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 매장 등록
    @Override
    public ResponseDto<PostStoreResponseDto> postStore(String email, PostStoreDto dto) {
        PostStoreResponseDto data = null;

        try {
            Integer userIdx = userRepository.findUserIdxByEmail(email);
            if(userIdx == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER_EAMIL);

            StoreEntity storeEntity = new StoreEntity(userIdx, dto);
            storeRepository.save(storeEntity);

            data = new PostStoreResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 매장 수정
    @Override
    public ResponseDto<PatchStoreResponseDto> patchStore(PatchStoreDto dto) {
        PatchStoreResponseDto data = null;
        Integer storeIdx = dto.getStoreIdx();

        try {
            StoreEntity storeEntity = storeRepository.findById(storeIdx).orElseThrow();
            storeEntity.patchStore(dto);
            storeRepository.save(storeEntity);

            data = new PatchStoreResponseDto(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 매장 삭제
    @Override
    @Transactional
    public ResponseDto<DeleteStoreResponseDto> deleteStore(Integer storeIdx) {
        DeleteStoreResponseDto data = null;

        try {
            if(!storeRepository.existsById(storeIdx)) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_STORE);
            storeRepository.deleteById(storeIdx);
            
            data = new DeleteStoreResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
