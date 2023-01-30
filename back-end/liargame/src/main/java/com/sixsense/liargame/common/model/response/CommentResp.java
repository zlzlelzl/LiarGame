package com.sixsense.liargame.common.model.response;

import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResp {
    private Long id;
    private String commentContent;
    private Article article;
    private Long commentWriter;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentResp(Comment comment) {
        this.id = comment.getId();
        this.commentContent = comment.getCommentContent();
        this.article = comment.getArticle();
        this.commentWriter = comment.getCommentWriter();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }

}
