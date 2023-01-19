package com.sixsense.liargame.db.repository;


import com.sixsense.liargame.db.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
