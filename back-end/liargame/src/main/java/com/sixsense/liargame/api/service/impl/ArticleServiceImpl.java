package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Override
    public void insertArticle(ArticleDetailReq article) {
        System.out.println("created article");
    }

    @Override
    public void deleteArticle(Long id) {

    }

    @Override
    public void updateArticle(ArticleDetailReq article) {
        //System.out.println("update");
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
