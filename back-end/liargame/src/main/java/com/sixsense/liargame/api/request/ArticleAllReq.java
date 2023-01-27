package com.sixsense.liargame.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArticleAllReq {
    private Long id;
    private String title;
    private String writer;
    private String updatedAt;
    private Integer viewCnt;
    private Boolean isNotice;

}
