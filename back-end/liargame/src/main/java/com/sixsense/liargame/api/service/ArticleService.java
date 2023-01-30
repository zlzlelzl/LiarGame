package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.db.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Long insertArticle(ArticleDetailReq article);

    List<ArticleResp> getArticles();

    void deleteArticle(Long id);

    Long updateArticle(Long id, ArticleDetailReq article);

    Optional<Article> getArticle(Long id);

}