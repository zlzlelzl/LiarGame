package com.sixsense.liargame.db.repository;

import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.repository.support.ArticleRepositorySupport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositorySupport {

}
