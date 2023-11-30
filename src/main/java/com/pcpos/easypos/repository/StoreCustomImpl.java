package com.pcpos.easypos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pcpos.easypos.entity.QStoreEntity;
import com.pcpos.easypos.entity.QUserEntity;
import com.pcpos.easypos.entity.StoreEntity;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;


public class StoreCustomImpl implements StoreCustom{

    @Autowired private JPAQueryFactory queryFactory;

    @Override
    public List<StoreEntity> findByEmail(String email) {

        QStoreEntity store = QStoreEntity.storeEntity;
        QUserEntity user = QUserEntity.userEntity;
        
        JPQLQuery<Tuple> query = queryFactory.select(
            store.storeIdx,
            store.storeName,
            store.openTime,
            store.closeTime,
            store.createdAt
        ).from(store)
        .join(user)
        .on(store.userIdx.eq(user.userIdx))
        .where(user.email.eq(email));

        return query.fetchJoin().fetch().stream().map(tupple -> new StoreEntity(
            tupple.get(store.storeIdx),
            tupple.get(store.userIdx),
            tupple.get(store.storeName),
            tupple.get(store.openTime),
            tupple.get(store.closeTime),
            tupple.get(store.createdAt)
            )).toList();
    }
    
}