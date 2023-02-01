package com.sixsense.liargame.api.request;

import com.sixsense.liargame.db.entity.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArticleAllReq {
    private Long id;
    private String title;
    private Long userId;
    private String userName;
    private LocalDateTime updatedAt;
    private Integer viewCnt;
    private Boolean isNotice;

    public Article articleToEntity() {
        return Article.builder()
                .title(title)
                .userId(userId)
                .userName(userName)
                .viewCnt(viewCnt)
                .isNotice(isNotice)
                .build();
    }

}
