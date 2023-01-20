package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void insertArticle(ArticleDetailReq article) {
        //System.out.println("created article");
    }

    @Override
    public void deleteArticle(Long id) {

    }

    @Override
    public void updateArticle(ArticleDetailReq article) {
        //System.out.println("update");
    }

    @Override
    @Transactional
    public ArticleResp getArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        article.updateViewCnt();
        return null;
    }

    @Override
    public List<ArticleResp> selectArticlepage(Long page) {
        return null;
    }

    @Override
    public List<ArticleResp> selectArticlekey(String key) {
        return null;
    }

    @Override
    public List<ArticleResp> selectArticleword(String word) {
        return null;
    }
}
