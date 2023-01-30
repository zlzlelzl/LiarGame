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
    private Long commentWriter;
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Comment(String commentContent) {
        this.commentContent = commentContent;
    }

    @Builder
    public Comment(Long id, String commentContent, Long articleId, Long commentWriter, Long userId, User user) {
        this.id = id;
        this.commentContent = commentContent;
        this.articleId = articleId;
        this.commentWriter = commentWriter;
        this.userId = userId;
        this.user = user;
    }

    public void updateComment(String commentContent) {

        this.commentContent = commentContent;
    }
}
