package com.sixsense.liargame.common.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDto {
    private Long id;
    private Long userId; //writer
    private Boolean isNotice;
    private String title;
    private String content;
    private Integer viewCnt;
}
