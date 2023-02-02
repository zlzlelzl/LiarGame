package com.sixsense.liargame.api.request;

import com.sixsense.liargame.common.model.response.UserDto;
import com.sixsense.liargame.db.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDetailReq {
    private String title;
    private String content;
    private Long userId;
    private Boolean isNotice;
    private Integer viewCnt;

    public Article articleToEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .isNotice(isNotice)
                .viewCnt(viewCnt)
                .build();
    }
}
