package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.repository.ArticleRepository;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Transactional
    public Long insertArticle(final ArticleDetailReq articleDetail) {
        Article article = articleRepository.save(articleDetail.articleToEntity());
        return article.getId();
    }

    @Override
    public List<ArticleResp> getArticles(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "updatedAt");
        List<Article> articles = articleRepository.findAll(sort);
        return articles.stream().map(ArticleResp::new).collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        articleRepository.delete(article.get());
        //articleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Long updateArticle(Long id, ArticleDetailReq article) {
        Article article1 = articleRepository.findById(id).orElseThrow(null);
//        if(article1 == null){
//            throw new RuntimeException("ARTICLES_NOT_FOUND");
//        }
        article1.updateArticle(article.getTitle(), article.getContent(), article.getIsNotice());
        return id;
    }

    @Override
    public Optional<Article> getArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(null);
        article.updateViewCnt();
        this.articleRepository.save(article);
        return this.articleRepository.findById(id);
    }

}
