package com.sixsense.liargame.db.entity;

import com.sixsense.liargame.api.request.ArticleModifyQuery;
import lombok.*;
import com.sixsense.liargame.common.model.request.ArticleDto;
import org.springframework.data.annotation.LastModifiedDate;
import reactor.util.annotation.Nullable;

import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id")
    private Long id;

    //@Column(name = "title")
    private String title;

    //@Column(name = "contents")
    private String content;

    //@Column(name = "isNotice", nullable = false)
    private Boolean isNotice;

    //@Column(name = "hits", nullable = false)
    private Integer viewCnt;

    //@Column(name = "user_id", nullable = false)
    private Long userId;

    @Builder
    public Article(Long id, String title, String content, Boolean isNotice, Integer viewCnt, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.viewCnt = viewCnt;
        this.userId = userId;
    }

    public void update(ArticleModifyQuery query) {
        this.title = query.getTitle();
        this.content = query.getContent();
    }

    public void updateViewCnt() {
        viewCnt++;
    }
}
