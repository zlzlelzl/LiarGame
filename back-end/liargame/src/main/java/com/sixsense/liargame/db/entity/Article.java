package com.sixsense.liargame.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class Article extends CommunityBaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    private String title;
    private String content;
    private Boolean isNotice;
    @Column(name = "user_id")
    private Long userId;
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    @ManyToOne
    private User user;
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer viewCnt;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;


    @Builder
    public Article(Long id, String title, String content, Boolean isNotice, Long userId, User user, Integer viewCnt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.userId = userId;
        this.user = user;
        this.viewCnt = viewCnt;
    }

    public void updateViewCnt() {
        viewCnt++;
    }

    public void updateArticle(String title, String content, Boolean isNotice) {
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
    }
}
