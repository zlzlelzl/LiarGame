package com.sixsense.liargame.db.entity;

import lombok.*;
import javax.persistence.*;
import com.sixsense.liargame.common.model.request.CommentDto;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends CommunityBaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    //@Column(name = "comment")
    private String comment;

//    //@Column(name = "article_id")
    private Long articleId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "article_id")
//    private Article article;

//    @Column(name = "user_id")
    private Long commentWriter;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    public void updateComment(String comment, LocalDateTime updatedAt){
        this.comment = comment;
        this.setUpdatedAt(updatedAt);
    }

    public Comment(Long id, String comment, User user, Article article){
        this.id = id;
        this.comment = comment;
        this.commentWriter = user.getId();
        this.articleId = article.getId();
    }
}
