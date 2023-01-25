package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.request.ArticleAllReq;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.db.entity.Article;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ArticleService {
    void insertArticle(ArticleDetailReq article);

    void deleteArticle(Long id);

    void updateArticle(ArticleDetailReq article);

    ArticleResp getArticle(Long id);

    List<ArticleResp> selectArticlepage(Long page);

    List<ArticleResp> selectArticlekey(String key);

    List<ArticleResp> selectArticleword(String word);

    default ArticleResp toResp(Article article){
        ArticleResp resp = ArticleResp.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .
                .build();
    }
}
