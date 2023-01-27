package com.sixsense.liargame.db.repository.support;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sixsense.liargame.db.entity.Comment;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

import static com.sixsense.liargame.db.entity.QComment.comment1;

@Repository
public class CommentRepositorySupportImpl implements CommentRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public CommentRepositorySupportImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Comment> findByCommentSet(Set<Long> set) {
        return queryFactory
                .select(comment1)
                .from(comment1)
                .where(comment1.id.in(set))
                .orderBy(new OrderSpecifier<>(Order.DESC, comment1.id))
                .fetch();
    }
}
