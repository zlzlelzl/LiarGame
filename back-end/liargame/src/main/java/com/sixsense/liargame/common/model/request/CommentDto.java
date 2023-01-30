package com.sixsense.liargame.common.model.request;

import com.sixsense.liargame.db.entity.Article;
import lombok.*;
import java.time.LocalDateTime;
import com.sixsense.liargame.db.entity.Comment;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long userId;
    //private String userName;
    private String content;
    private Long articleId;

    //commentToEntity
    public Comment commentToEntity() {
        return Comment.builder()
                .commentContent(this.commentContent)
                .commentWriter(this.commentWriter)
                .article(this.article)
                .build();
    }

}
