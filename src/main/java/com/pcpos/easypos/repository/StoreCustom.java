package com.pcpos.easypos.repository;

import java.util.List;

import com.pcpos.easypos.entity.StoreEntity;

public interface StoreCustom {
    
    public List<StoreEntity> findByEmail(String email);
}
