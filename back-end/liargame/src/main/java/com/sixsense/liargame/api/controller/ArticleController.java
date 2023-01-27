package com.sixsense.liargame.api.controller;

import com.sixsense.liargame.api.request.ArticleAllReq;
import com.sixsense.liargame.api.request.ArticleDetailReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.service.ArticleService;
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
//    @GetMapping("/")
//    public ResponseEntity<List<ArticleResp>> getArticles(){
//        return ResponseEntity.ok().body(articleService.getArticles());
//    }

    @PostMapping
    public Long createArticle(@RequestBody ArticleDetailReq article){
        return articleService.insertArticle(article);
    }
//    @PostMapping
//    public ResponseEntity<?> writeArticle(@RequestBody final ArticleDetailReq articleDetailReq){
//        articleService.insertArticle(articleDetailReq);
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("/page/{page}")
//    public ResponseEntity<List<ArticleResp>> findArticles(int page, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
//        System.out.println();
//
//        return ResponseEntity.ok().body(articleService.findArticles(page));
//    }
//
//    @GetMapping("/key/{key}")
//    public ResponseEntity<List<ArticleResp>> getArticleByKey(@PathVariable("key") String key){
//        return ResponseEntity.ok().body(articleService.selectArticlekey(key));
//    }
//
//    @GetMapping("/word/{word}")
//    public ResponseEntity<List<ArticleResp>> getArticleByWord(@PathVariable("word") String word){
//        return ResponseEntity.ok().body(articleService.selectArticleword(word));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateArticle(@PathVariable("id") Long id, @RequestBody ArticleDetailReq article) {
//        articleService.updateArticle(article);
//        return ResponseEntity.ok().build();
//    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchArticle(@PathVariable ("id") Long id, @RequestBody ArticleDetailReq article){
        articleService.updateArticle(id, article);
        return ResponseEntity.ok().build();
    }

}


