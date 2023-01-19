package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.request.ArticleAllReq;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ArticleService {
    void insertArticle(ArticleDetailReq article);

    void deleteArticle(Long id);

    void updateArticle(ArticleDetailReq article);

    List<ArticleResp> selectArticlepage(Long page);

    List<ArticleResp> selectArticlekey(String key);

    List<ArticleResp> selectArticleword(String word);


}
