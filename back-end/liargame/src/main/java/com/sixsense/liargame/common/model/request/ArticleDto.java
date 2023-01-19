package com.sixsense.liargame.common.model.request;

import lombok.*;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDto {
    private Long userId;
    private boolean isNotice;

}
