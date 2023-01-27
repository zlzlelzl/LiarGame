package com.sixsense.liargame.api.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleModifyQuery {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime updatedAt;
}
