package com.sixsense.liargame.common.model.response;

import com.sixsense.liargame.db.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResp {
    private Long id;
    private String comment;
    private Long articleId;
    private Long commentWriter;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentResp(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.articleId = comment.getArticleId();
        this.commentWriter = comment.getCommentWriter();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }

}
