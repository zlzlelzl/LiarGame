package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void insertArticle(ArticleDetailReq articleDetail) {
        Article article = Article.builder()
                .title(articleDetail.getTitle())
                .content(articleDetail.getContent())
                .build();
        Long articleId = articleRepository.save(article).getId();

    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleDetailReq article) {
        articleRepository.save(Article.builder()
              .title(article.getTitle())
              .content(article.getContent())
                .build());
    }

    @Override
    public ArticleResp getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return ArticleResp.builder()
                    .id(article.get().getId())
                    .title(article.get().getTitle())
                    .content(article.get().getContent())
                    .build();
        }
        return null;
    }

    @Override
    public List<ArticleResp> findArticles(int page) {
        return null;
    }

    @Override
    public List<ArticleResp> findArticles(int page, Pageable pageable) {
        Page<Article> articlePage = articleRepository.findAll(PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "id")));
        List<Article> articles = articlePage.getContent();
        return (List<ArticleResp>) articles.stream().map(article -> ArticleResp.builder()
                .id(article.getId())
                .title(article.getTitle())
                .writer(article.getWriter())
                .updatedAt(article.getUpdatedAt())
                .viewCnt(article.getViewCnt())
                .build());
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
