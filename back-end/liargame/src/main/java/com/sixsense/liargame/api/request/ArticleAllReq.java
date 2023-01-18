package com.sixsense.liargame.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArticleAllReq {
    private long id;
    private String title;
    private int userId;
    private String createdAt;
    private int viewCnt;
    private boolean isNotice;

}
