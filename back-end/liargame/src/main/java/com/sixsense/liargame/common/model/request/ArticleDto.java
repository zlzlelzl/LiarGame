package com.sixsense.liargame.common.model.request;

import lombok.*;
import com.sixsense.liargame.db.entity.Article;

@Getter
@NoArgsConstructor
public class ArticleDto {
    private String title;
    private String content;
    private Long writer;


    //toEntity
    public Article articleToEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .viewCnt(1)
                .build();
    }
}
