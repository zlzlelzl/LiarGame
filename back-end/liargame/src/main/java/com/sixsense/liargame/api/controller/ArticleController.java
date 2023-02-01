package com.sixsense.liargame.api.controller;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    // get list as restful
    @GetMapping
    public ResponseEntity<List<ArticleResp>> getArticles() {
        return ResponseEntity.ok().body(articleService.getArticles());
    }

    @PostMapping
    public Long createArticle(@RequestBody ArticleDetailReq article) {
        return articleService.insertArticle(article);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<?> getArticle(@PathVariable Long articleId) {

        Article article = articleService.getArticle(articleId);
//        System.out.println(article.getViewCnt());
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{articleId}")
    public ResponseEntity<?> patchArticle(@PathVariable Long articleId, @RequestBody ArticleDetailReq article) {
        articleService.updateArticle(articleId, article);
        return ResponseEntity.ok().build();
    }

}


