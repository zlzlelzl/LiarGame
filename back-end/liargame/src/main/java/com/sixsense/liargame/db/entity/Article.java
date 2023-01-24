package com.sixsense.liargame.db.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
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

    //@Column(name = "hits", nullable = false)
    private Integer viewCnt;

    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}
