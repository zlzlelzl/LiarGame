package com.sixsense.liargame.api.controller;

import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    // get list as restful
    @GetMapping
    public ResponseEntity<List<ArticleResp>> getArticles(@RequestBody Pageable pageable) {
        return ResponseEntity.ok(articleService.getArticles(pageable));
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(HttpServletRequest request, @RequestBody ArticleDetailReq article) {
        request.getHeader()
        return ResponseEntity.ok(articleService.insert`Article(article));
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<?> getArticle(@PathVariable Long articleId) {
        Article article = articleService.getArticle(articleId);
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


