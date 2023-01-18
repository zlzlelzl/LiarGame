package com.sixsense.liargame.api.request;

import com.sixsense.liargame.common.model.request.GameUserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDetailReq {
    private long id;
    private String title;
    private String content;
    private GameUserDto user;
    private String createdAt;
    private int viewCnt;
}
