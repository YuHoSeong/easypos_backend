package com.pcpos.easypos.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpos.easypos.common.constants.ResponseMessage;
import com.pcpos.easypos.dto.request.product.PatchProductDto;
import com.pcpos.easypos.dto.request.product.PostProductDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.product.DeleteProductResponseDto;
import com.pcpos.easypos.dto.response.product.GetProductListResponseDto;
import com.pcpos.easypos.dto.response.product.GetProductResponseDto;
import com.pcpos.easypos.dto.response.product.PatchProductResponseDto;
import com.pcpos.easypos.dto.response.product.PostProductResponseDto;
import com.pcpos.easypos.entity.ProductEntity;
import com.pcpos.easypos.repository.ProductRepository;
import com.pcpos.easypos.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductRepository productRepository;

    // 매장 상품 조회
    @Override
    public ResponseDto<List<GetProductListResponseDto>> getProductList(Integer storeIdx) {
        List<GetProductListResponseDto> data = null;

        try {
            List<ProductEntity> productEntities = productRepository.findByStoreIdx(storeIdx);
            data = GetProductListResponseDto.copyList(productEntities);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 상품 상세 조회
    @Override
    public ResponseDto<GetProductResponseDto> getProduct(Integer productIdx) {
        GetProductResponseDto data = null;

        try {
            ProductEntity productEntity = productRepository.findById(productIdx).orElseThrow();
            data = new GetProductResponseDto(productEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 상품 추가
    @Override
    public ResponseDto<PostProductResponseDto> postProduct(PostProductDto dto) {
        PostProductResponseDto data = null;
        
        try {
            ProductEntity productEntity = new ProductEntity(dto);
            productRepository.save(productEntity);

            data = new PostProductResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 상품 수정
    @Override
    public ResponseDto<PatchProductResponseDto> patchProduct(PatchProductDto dto) {
        PatchProductResponseDto data = null;
        Integer productIdx = dto.getProductIdx();

        try {
            ProductEntity productEntity = productRepository.findById(productIdx).orElseThrow();
            productEntity.patchProduct(dto);

            productRepository.save(productEntity);

            data = new PatchProductResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 상품 삭제
    @Override
    @Transactional
    public ResponseDto<DeleteProductResponseDto> deleteProduct(Integer productIdx) {
        DeleteProductResponseDto data = null;

        try {
            if(!productRepository.existsById(productIdx)) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_PRODUCT);
            productRepository.deleteById(productIdx);

            data = new DeleteProductResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
