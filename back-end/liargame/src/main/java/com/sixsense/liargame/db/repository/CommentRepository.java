package com.sixsense.liargame.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sixsense.liargame.db.entity.Article;
import com.sixsense.liargame.db.entity.Comment;
import java.util.List;
public interface CommentRepository extends JpaRepository<Comment, Long>{
    // select * from comment where article_id=? order by id desc;
    List<Comment> findByArticle();
}
