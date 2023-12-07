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
import com.pcpos.easypos.dto.request.product.PatchProductDto;
import com.pcpos.easypos.dto.request.product.PostProductDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.product.DeleteProductResponseDto;
import com.pcpos.easypos.dto.response.product.GetProductListResponseDto;
import com.pcpos.easypos.dto.response.product.GetProductResponseDto;
import com.pcpos.easypos.dto.response.product.PatchProductResponseDto;
import com.pcpos.easypos.dto.response.product.PostProductResponseDto;
import com.pcpos.easypos.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPattern.PRODUCT)
@Slf4j
public class ProductController {

    @Autowired private ProductService productService;

    private final String GET_PRODUCT_LIST = "/list/{storeIdx}";
    private final String GET_PRODUCT = "/{productIdx}";
    private final String POST_PRODUCT = "/";
    private final String PATCH_PRODUCT = "/";
    private final String DELETE_PRODUCT = "/{productIdx}";

    // 매장 상품 조회
    @GetMapping(GET_PRODUCT_LIST)
    public ResponseDto<List<GetProductListResponseDto>> getProductList(@PathVariable Integer storeIdx){
        log.info("getProductList");
        ResponseDto<List<GetProductListResponseDto>> response = productService.getProductList(storeIdx);
        return response;
    }

    // 상품 상세 조회
    @GetMapping(GET_PRODUCT)
    public ResponseDto<GetProductResponseDto> getProduct(@PathVariable Integer productIdx){
        log.info("getProduct");
        ResponseDto<GetProductResponseDto> response = productService.getProduct(productIdx);
        return response;
    }

    // 상품 추가
    @PostMapping(POST_PRODUCT)
    public ResponseDto<PostProductResponseDto> postProduct(@RequestBody PostProductDto dto){
        log.info("postProduct");
        ResponseDto<PostProductResponseDto> response = productService.postProduct(dto);
        return response;
    }

    // 상품 수정
    @PatchMapping(PATCH_PRODUCT)
    public ResponseDto<PatchProductResponseDto> patchProduct(@RequestBody PatchProductDto dto){
        log.info("patchProduct");
        ResponseDto<PatchProductResponseDto> response = productService.patchProduct(dto);
        return response;
    }

    // 상품 삭제
    @DeleteMapping(DELETE_PRODUCT)
    public ResponseDto<DeleteProductResponseDto> deleteProduct(@PathVariable Integer productIdx){
        log.info("deleteProduct");
        ResponseDto<DeleteProductResponseDto> response = productService.deleteProduct(productIdx);
        return response;
    }


}
