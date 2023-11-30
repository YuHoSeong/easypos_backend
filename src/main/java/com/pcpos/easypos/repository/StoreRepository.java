package com.pcpos.easypos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcpos.easypos.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer>, StoreCustom{
    
}
