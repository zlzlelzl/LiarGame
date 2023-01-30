package com.sixsense.liargame.api.response;

import com.sixsense.liargame.common.model.response.UserDto;
import com.sixsense.liargame.db.entity.Article;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleResp {
    private Long id;
    private String title;
    private String content;
    private Boolean isNotice;
    private Long writer;
    private Integer viewCnt;
    private List<CommentResp> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public ArticleResp(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.isNotice = article.getIsNotice();
        this.writer = article.getWriter();
        this.comments = article.getComments().stream().map(CommentResp::new).collect(Collectors.toList());
        this.viewCnt = article.getViewCnt();
        this.updatedAt = article.getUpdatedAt();
    }
}
