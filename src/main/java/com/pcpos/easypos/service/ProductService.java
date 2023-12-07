package com.pcpos.easypos.service;

import java.util.List;

import com.pcpos.easypos.dto.request.product.PatchProductDto;
import com.pcpos.easypos.dto.request.product.PostProductDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.product.DeleteProductResponseDto;
import com.pcpos.easypos.dto.response.product.GetProductListResponseDto;
import com.pcpos.easypos.dto.response.product.GetProductResponseDto;
import com.pcpos.easypos.dto.response.product.PatchProductResponseDto;
import com.pcpos.easypos.dto.response.product.PostProductResponseDto;

public interface ProductService {
    // 매장 상품 조회
    public ResponseDto<List<GetProductListResponseDto>> getProductList(Integer storeIdx);
    // 상품 상세 조회
    public ResponseDto<GetProductResponseDto> getProduct(Integer productIdx);
    // 상품 추가
    public ResponseDto<PostProductResponseDto> postProduct(PostProductDto dto);
    // 상품 수정
    public ResponseDto<PatchProductResponseDto> patchProduct(PatchProductDto dto);
    // 상품 삭제
    public ResponseDto<DeleteProductResponseDto> deleteProduct(Integer productIdx);
    
}
