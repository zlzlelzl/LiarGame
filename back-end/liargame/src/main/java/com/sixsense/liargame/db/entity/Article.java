package com.sixsense.liargame.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class Article extends CommunityBaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    //@Column(name = "title")
    private String title;

    //@Column(name = "contents")
    private String content;

    //@Column(name = "isNotice", nullable = false)
    private Boolean isNotice;

    //@Column(name = "writer")
    private Long writer;

    //@Column(name = "hits", nullable = false, columnDefinition = "integer default 0")
    private Integer viewCnt;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @OrderBy("updatedAt DESC")
    private List<Comment> comments;


    public Article(Long id, String title, String content, Boolean isNotice, User user, Integer viewCnt, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.writer = user.getId();
        this.viewCnt = viewCnt;
        this.comments = comments;
    }

    @Builder
    public Article(Long id, String title, String content, Boolean isNotice, Long writer, Integer viewCnt, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.writer = writer;
        this.viewCnt = viewCnt;
        this.comments = comments;
    }

    public void updateArticle(String title, String content, Boolean isNotice) {
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
    }

    public void updateViewCnt() {
        viewCnt++;
    }
}
