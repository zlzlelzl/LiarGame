package com.sixsense.liargame.db.entity;

import com.sixsense.liargame.api.request.ArticleModifyQuery;
import lombok.*;
import com.sixsense.liargame.common.model.request.ArticleDto;
import org.springframework.data.annotation.LastModifiedDate;
import reactor.util.annotation.Nullable;

import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Article extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="article_id")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void userid(){
        this.writer = user.getId();
    }

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "article")
    @OrderBy("id asc")
    private List<Comment> comments;

    public void update(ArticleModifyQuery query) {
        this.title = query.getTitle();
        this.content = query.getContent();
    }

    public void updateViewCnt() {
        viewCnt++;
    }
}
