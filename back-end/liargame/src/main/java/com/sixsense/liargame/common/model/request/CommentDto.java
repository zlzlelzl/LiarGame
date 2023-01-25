package com.sixsense.liargame.common.model.request;

import lombok.*;
import java.time.LocalDateTime;
import com.sixsense.liargame.db.entity.Comment;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private Long userId;
    //private String userName;
    private String comment;
    private Long articleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentDto toCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setUserId(comment.getUserId());
        //commentDto.setUserName(comment.getUserName();
        commentDto.setComment(comment.getComment());
        commentDto.setCreatedAt(comment.getCreatedAt());
        commentDto.setUpdatedAt(comment.getUpdatedAt());
        commentDto.setArticleId(comment.getArticleId());
        return commentDto;
    }
}
