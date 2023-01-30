package com.sixsense.liargame.api.request;

import com.sixsense.liargame.api.response.CommentResp;
import com.sixsense.liargame.common.model.response.UserDto;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.entity.Comment;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDetailReq {
    //private Long id;
    private String title;
    private String content;
    private Long writer;
    private Boolean isNotice;
    private Integer viewCnt;
    private List<Comment> comments;

    public Article articleToEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .isNotice(isNotice)
                .viewCnt(viewCnt)
                .comments(comments)
                .build();
    }
}
