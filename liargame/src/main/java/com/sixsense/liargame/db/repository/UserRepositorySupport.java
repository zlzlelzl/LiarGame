package com.sixsense.liargame.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sixsense.liargame.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.sixsense.liargame.db.entity.QUser.user;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class UserRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public Optional<User> findUserByUserId(String userId) {
        User userEntity = jpaQueryFactory.select(user).from(user)
                .where(user.userId.eq(userId)).fetchOne();
        return Optional.ofNullable(userEntity);
    }
}
