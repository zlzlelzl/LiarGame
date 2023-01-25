package com.sixsense.liargame.db.repository.support;

import com.sixsense.liargame.db.entity.Comment;
import java.util.List;
import java.util.Set;
public interface CommentRepositorySupport {
    List<Comment> findByCommentSet(Set<Long> set);
}
