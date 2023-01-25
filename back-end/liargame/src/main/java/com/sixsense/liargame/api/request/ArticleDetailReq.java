package com.sixsense.liargame.api.request;

import com.sixsense.liargame.common.model.response.UserDto;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDetailReq {

    private String title;
    private String content;
    private UserDto user;
    private LocalDateTime date;
    private int viewCnt;
}
