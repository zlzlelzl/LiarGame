package com.sixsense.liargame.api.request;

import com.sixsense.liargame.db.entity.Article;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArticleAllReq {
    private Long id;
    private String title;
    private Long writer;
    private LocalDateTime updatedAt;
    private Integer viewCnt;
    private Boolean isNotice;

    public Article articleToEntity() {
        return Article.builder()
                .title(title)
                .writer(writer)
                .viewCnt(viewCnt)
                .isNotice(isNotice)
                .build();
    }

}
