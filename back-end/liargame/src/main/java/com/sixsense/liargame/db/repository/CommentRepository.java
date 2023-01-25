package com.sixsense.liargame.db.repository;

import com.sixsense.liargame.db.repository.support.CommentRepositorySupport;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sixsense.liargame.db.entity.Comment;
public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositorySupport {
}
