package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.repository.ArticleRepository;
import com.sixsense.liargame.db.repository.UserRepository;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Service
public class ArticleServiceImpl implements ArticleService {
    private final UserRepository userRepository;
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository,
                              UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Article insertArticle(final ArticleDetailReq articleDetail) {
        Article article = articleRepository.save(articleDetail.articleToEntity());
        return article;
    }

    @Override
    public Article getArticle(Long id) {
        articleRepository.updateViewCnt(id);
        return articleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ArticleResp> getArticles(Pageable pageable) {
        PageRequest pageRequest = (PageRequest) pageable;
        pageRequest.withSort(Sort.by(Sort.Direction.DESC, "id", "updatedAt"));
        Page<Article> articles = articleRepository.findAll(pageRequest);
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
        article1.updateArticle(article.getTitle(), article.getContent(), article.getIsNotice());
        articleRepository.save(article1);
        return id;
    }

}
