package com.sixsense.liargame.db.entity;

import com.sixsense.liargame.api.request.ArticleModifyQuery;
import com.sixsense.liargame.db.repository.ArticleRepository;
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
@ToString
public class Article extends CommunityBaseTime{
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

    //@Column(name = "writer")
    private Long writer;

    //@Column(name = "hits", nullable = false, columnDefinition = "integer default 0")
    private Integer viewCnt;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "article")
    @OrderBy("updatedAt DESC")
    private List<Comment> comments;


    public void updateArticle(String title, String content, Boolean isNotice) {
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
    }

    public void updateViewCnt() {
        viewCnt++;
    }

    public Article(Long id, String title, String content, Boolean isNotice, User user, Integer viewCnt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.writer = user.getId();
        this.viewCnt = viewCnt;
    }
}
