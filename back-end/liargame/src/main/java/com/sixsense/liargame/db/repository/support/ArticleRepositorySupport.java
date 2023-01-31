package com.sixsense.liargame.db.repository.support;

import com.sixsense.liargame.db.entity.Article;

import java.util.List;
import java.util.Set;

public interface ArticleRepositorySupport {
    List<Article> findByArticleSet(Set<Long> set);

    List<Article> findByTitleContaining(String key);

    Integer updateViewCnt(Long articleId);
}
