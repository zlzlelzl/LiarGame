package com.sixsense.liargame.api.response;

import com.sixsense.liargame.common.model.response.UserDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleResp {
    private long id;
    private String title;
    private String content;
    private boolean isNotice;
    private Long writer;
    private Integer viewCnt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
