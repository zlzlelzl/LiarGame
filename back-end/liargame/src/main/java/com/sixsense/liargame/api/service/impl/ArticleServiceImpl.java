package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.api.service.CommentService;
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
    private CommentService commentService;

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
    public List<ArticleResp> getArticles() {
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
        article1.updateArticle(article.getTitle(), article.getContent(), article.getIsNotice());
        articleRepository.save(article1);
        return id;
    }

    @Override
    public Article getArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(null);
        System.out.println(article);
//        List<Comment> comments = null;
//        if (article.getComments() != null) {
//            comments = commentService.findAllByArticleId(id);
//            System.out.println(comments);
//        }
//        List<Comment> comments = commentService.findAllByArticleId(id);
//        article.updateViewCnt(article.getViewCnt());
        return article;
    }

}
