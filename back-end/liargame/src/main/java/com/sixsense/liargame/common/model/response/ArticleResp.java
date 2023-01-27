package com.sixsense.liargame.common.model.response;

import lombok.Getter;
import com.sixsense.liargame.db.entity.Article;
import java.time.LocalDateTime;

@Getter
public class ArticleResp {
    private Long id;
    private String title;
    private String content;
    private Boolean isNotice;
    private Long writer;
    private Integer viewCnt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ArticleResp(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.isNotice = article.getIsNotice();
        this.writer = article.getWriter();
        this.viewCnt = article.getViewCnt();
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();
    }

//    public String getContent() {
//        return content;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
}
