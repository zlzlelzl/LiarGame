package com.sixsense.liargame.api.controller;

import com.sixsense.liargame.api.request.ArticleAllReq;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping
    public ResponseEntity<?> writeArticle(HttpServletRequest request, @RequestBody ArticleDetailReq articleDetailReq){
        articleService.insertArticle(articleDetailReq);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{page}")
    public ResponseEntity<List<ArticleResp>> getArticle(@PathVariable("page") Long page){
        return ResponseEntity.ok().body(articleService.selectArticlepage(page));
    }

    @GetMapping("/{key}")
    public ResponseEntity<List<ArticleResp>> getArticleByKey(@PathVariable("key") String key){
        return ResponseEntity.ok().body(articleService.selectArticlekey(key));
    }

    @GetMapping("/{word}")
    public ResponseEntity<List<ArticleResp>> getArticleByWord(@PathVariable("word") String word){
        return ResponseEntity.ok().body(articleService.selectArticleword(word));
    }
}


