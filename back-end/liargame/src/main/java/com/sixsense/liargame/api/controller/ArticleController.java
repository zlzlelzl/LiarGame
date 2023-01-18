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
    public ResponseEntity<?> writeArticle(@RequestBody ArticleAllReq articleAllReq, HttpServletRequest request){
        articleService.insertArticle(articleAllReq);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
}


public class ArticleController {
}
