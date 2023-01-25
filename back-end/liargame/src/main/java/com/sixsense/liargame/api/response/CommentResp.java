package com.sixsense.liargame.api.response;

import com.sixsense.liargame.common.model.response.ArticleResp;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResp {
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ArticleResp> articles;
}
