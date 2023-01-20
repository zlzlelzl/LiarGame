package com.sixsense.liargame.api.request;

import lombok.Data;

@Data
public class ArticleModifyQuery {
    private Long id;
    private String title;
    private String content;
}
