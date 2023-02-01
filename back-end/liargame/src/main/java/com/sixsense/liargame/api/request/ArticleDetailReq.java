package com.sixsense.liargame.api.request;

import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDetailReq {
    //private Long id;
    private String title;
    private String content;
    private Long userId;
    private String userName;
    private Boolean isNotice;
    private Integer viewCnt;
    private List<Comment> comments;

    public Article articleToEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .userName(userName)
                .isNotice(isNotice)
                .viewCnt(viewCnt)
                .comments(comments)
                .build();
    }
}
