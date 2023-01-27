package com.sixsense.liargame.api.response;

import com.sixsense.liargame.common.model.response.UserDto;
import com.sixsense.liargame.db.entity.Article;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleResp {
    private long id;
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
    }
}
