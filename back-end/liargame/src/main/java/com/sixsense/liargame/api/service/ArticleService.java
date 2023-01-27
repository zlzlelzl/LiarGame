package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.db.entity.Article;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    Long insertArticle(ArticleDetailReq article);

    List<ArticleResp> findAll();

    void deleteArticle(Long id);

    Long updateArticle(Long id, ArticleDetailReq article);

    ArticleResp getArticle(Long id);

    //페이지 설정
    List<ArticleResp> findArticles(int page);

//    List<ArticleResp> findArticles(int page, Pageable pageable);

    //키워드 검색
    List<ArticleResp> selectArticlekey(String key);

    List<ArticleResp> selectArticleword(String word);

    default ArticleResp toResp(Article article){
        ArticleResp resp = ArticleResp.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
        return resp;
    }

}
