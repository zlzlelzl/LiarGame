package com.sixsense.liargame.api.request;

import com.sixsense.liargame.db.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentReq {
    private String commentContent;
    private Long userId;
    private String userName;
    private Long articleId;
    private String createdAt;
    private String updatedAt;

    //DtoToEntity
    public Comment commentToEntity(Long articleId) {

        return Comment.builder()
                .commentContent(commentContent)
                .userId(userId)
                .userName(userName)
                .articleId(articleId)
                .build();
    }

}
