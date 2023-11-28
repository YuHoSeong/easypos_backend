package com.pcpos.easypos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcpos.easypos.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>, ProductCustom{
    
}
