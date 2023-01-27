package com.sixsense.liargame.db.repository.support;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sixsense.liargame.db.entity.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static com.sixsense.liargame.db.entity.QArticle.article;

@Repository
public class ArticleRepositorySupportImpl implements ArticleRepositorySupport {
    private final JPAQueryFactory query;

    public ArticleRepositorySupportImpl(JPAQueryFactory query) {
        this.query = query;
    }

    @Override
    public List<Article> findByArticleSet(Set<Long> set) {
        return query
                .select(article)
                .from(article)
                .where(article.id.in(set))
                .orderBy(new OrderSpecifier<>(Order.DESC, article.id))
                .fetch();
    }

    @Override
    @Transactional
    public List<Article> findByTitleContaining(String key) {
        List<Article> articleList;
        //articleList = ArticleRepositorySupport.findByTitleContaining(key);

        //return articleList;
        return null;
    }

//    @Override
//    @Transactional
//    public findAll()

//    @Override
//    @Transactional
//    public List<Article> findByArticleSet(Set<Long> set) {
//        List<Article> articleList = ArticleRepositorySupportImpl.findByArticleSet(set);
//        return articleList;
//    }
}
