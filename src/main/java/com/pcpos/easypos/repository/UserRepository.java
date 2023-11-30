package com.pcpos.easypos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcpos.easypos.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, UserCustom {
    public boolean existsByEmail(String email);
    public UserEntity findByEmail(String email);
    public void deleteByEmail(String email);
    
}
