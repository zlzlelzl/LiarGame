package com.sixsense.liargame.db.entity;

import lombok.*;
import javax.persistence.*;
import com.sixsense.liargame.common.model.request.CommentDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    //@Column(name = "user_id")
    private Long userId;

    //@Column(name = "user_name")
    //private String userName;

    //@Column(name = "comment")
    private String comment;

    //@Column(name = "article_id")
    private Long articleId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "article_id")
//    private Article article;

    public static Comment toSaveComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setUserId(commentDto.getUserId());
        //comment.setUserName(commentDto.getUserName());
        comment.setArticleId(commentDto.getArticleId());
        return comment;
    }
}
