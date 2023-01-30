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
    private Long id;
    private String commentContent;
    private LocalDateTime updatedAt;
    private Long commentWriter;
    private Long articleId;

    //EntityToDto
    public CommentResp(Comment comment) {
        this.id = comment.getId();
        this.commentContent = comment.getCommentContent();
        this.updatedAt = comment.getUpdatedAt();
        this.commentWriter = comment.getCommentWriter();
        this.articleId = comment.getArticleId();
    }
}
