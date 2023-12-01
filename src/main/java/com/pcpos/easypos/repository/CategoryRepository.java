package com.pcpos.easypos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcpos.easypos.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
    public List<CategoryEntity> findByStoreIdxOrderByPriorityDesc(Integer storeIdx);
}
