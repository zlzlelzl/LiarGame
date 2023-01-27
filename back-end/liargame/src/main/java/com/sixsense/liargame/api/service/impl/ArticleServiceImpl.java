package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.request.ArticleModifyQuery;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.repository.ArticleRepository;
import com.sixsense.liargame.db.repository.support.ArticleRepositorySupportImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Transactional
    public Long insertArticle(final ArticleDetailReq articleDetail) {
        System.out.println(articleDetail.articleToEntity());
        Article article = articleRepository.save(articleDetail.articleToEntity());
        return article.getId();
//        Article article = Article.builder()
//                .title(articleDetail.getTitle())
//                .content(articleDetail.getContent())
//                .isNotice(articleDetail.getIsNotice())
//                .writer(articleDetail.getWriter())
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
//                .build();
//        Long articleId = articleRepository.save(article).getId();
    }

    @Override
    public List<ArticleResp> findAll(){
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
    public Long updateArticle(Long id, ArticleModifyQuery article) {
        Article article1 = articleRepository.findById(id).get();
        article1.updateArticle(article.getTitle(), article.getContent(), article.getIsNotice());
        return id;
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

//    @Override
//    public List<ArticleResp> findArticles(int page, Pageable pageable) {
//        Page<Article> articlePage = articleRepository.findAll(PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "id")));
//        List<Article> articles = articlePage.getContent();
//        return (List<ArticleResp>) articles.stream().map(article -> ArticleResp.builder()
//                .id(article.getId())
//                .title(article.getTitle())
//                .writer(article.getWriter())
//                .updatedAt(article.getUpdatedAt())
//                .viewCnt(article.getViewCnt())
//                .build());
//    }

    @Override
    public List<ArticleResp> selectArticlekey(String key) {


        return null;
    }

    @Override
    public List<ArticleResp> selectArticleword(String word) {
        return null;
    }

}
