package com.sixsense.liargame.api.response;

//import com.sixsense.liargame.common.model.response.ArticleResp;
import com.sixsense.liargame.db.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResp {
    private String commentContent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ArticleResp> articles;

    public CommentResp(Comment comment) {
    }
}
