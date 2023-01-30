package com.sixsense.liargame.api.request;

import com.sixsense.liargame.db.entity.Comment;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CommentReq {
    private String commentContent;
    private Long commentWriter;
    private Long articleId;
    private String createdAt;
    private String updatedAt;

    public Comment commentToEntity(Long articleId){
        return Comment.builder()
                .commentContent(commentContent)
                .commentWriter(commentWriter)
                .articleId(articleId)
                .build();
    }

}
