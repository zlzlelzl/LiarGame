package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.request.CommentReq;
import com.sixsense.liargame.api.response.CommentResp;
import com.sixsense.liargame.db.entity.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Long insertComments(Long articleId, CommentReq commentReq);

    Long deleteComment(Long id);

    Long updateComment(Long articleId, Long commentId, CommentReq commentReq);

    List<CommentResp> findAllComments(Long articleId, Pageable pageable);

    List<Comment> findAllByArticleId(Long articleId);
}
