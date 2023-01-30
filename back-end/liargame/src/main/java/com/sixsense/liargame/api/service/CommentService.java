package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.request.CommentReq;
import com.sixsense.liargame.api.response.ArticleResp;
import com.sixsense.liargame.api.response.CommentResp;

import java.util.List;

public interface CommentService {
    Long insertComments(Long articleId, CommentReq commentReq);

    Long deleteComment(Long id);

    Long updateComment(Long articleId, CommentReq commentReq);

    List<CommentResp> findAllComments(Long articleId);
}
