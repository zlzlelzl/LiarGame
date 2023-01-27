package com.sixsense.liargame.api.request;

import com.sixsense.liargame.common.model.response.UserDto;
import com.sixsense.liargame.db.entity.Article;
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

    public Article articleToEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .isNotice(isNotice)
                .build();
    }
}
