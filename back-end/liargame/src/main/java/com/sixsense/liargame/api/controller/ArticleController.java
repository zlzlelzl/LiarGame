package com.sixsense.liargame.api.controller;

import com.sixsense.liargame.api.request.ArticleAllReq;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.request.ArticleModifyQuery;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import com.sixsense.liargame.db.repository.ArticleRepository;
import com.sixsense.liargame.db.entity.Article;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    // get list as restful
    @GetMapping
    public ResponseEntity<List<ArticleResp>> getArticles(){
        return ResponseEntity.ok().body(articleService.getArticles());
    }

    @PostMapping
    public Long createArticle(@RequestBody ArticleDetailReq article){

        return articleService.insertArticle(article);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<?> getArticle(@PathVariable("articleId") Long articleId, @PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok().body(articleService.getArticle(articleId));
    }

    @DeleteMapping("/{articleId}")
    public Long deleteArticle(@PathVariable("articleId") Long id){
        articleService.deleteArticle(id);
        return id;
    }

    @PatchMapping("/{articleId}")
    public ResponseEntity<?> patchArticle(@PathVariable ("articleId") Long id, @RequestBody ArticleDetailReq article){
        articleService.updateArticle(id, article);
        return ResponseEntity.ok().build();
    }

}


