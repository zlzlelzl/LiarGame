package com.sixsense.liargame.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Comment extends CommunityBaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String commentContent;
    private Long articleId;
    //    @Column(name = "user_id")
    private Long userId;
    private String userName;
//    @ManyToOne
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private User user;

    @Builder
    public Comment(Long id, String commentContent, Long articleId, Long userId, String userName) {
        this.id = id;
        this.commentContent = commentContent;
        this.articleId = articleId;
        this.userId = userId;
        this.userName = userName;
    }

//    public Comment(String commentContent) {
//        this.commentContent = commentContent;
//    }

//    @Builder
//    public Comment(Long id, String commentContent, Long articleId, Long userId, User user) {
//        this.id = id;
//        this.commentContent = commentContent;
//        this.articleId = articleId;
//        this.userId = userId;
//        this.user = user;
//    }

    public void updateComment(String commentContent) {

        this.commentContent = commentContent;
    }
}
