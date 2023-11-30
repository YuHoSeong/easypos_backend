package com.pcpos.easypos.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.pcpos.easypos.entity.QUserEntity;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UserCustomImpl implements UserCustom {

    @Autowired private JPAQueryFactory queryFactory;

    @Override
    public Integer findUserIdxByEmail(String email) {

        QUserEntity user = QUserEntity.userEntity;
        
        JPQLQuery<Integer> query = queryFactory.select(user.userIdx)
            .from(user)
            .where(user.email.eq(email));

        return query.fetchOne();
    }
    
}
