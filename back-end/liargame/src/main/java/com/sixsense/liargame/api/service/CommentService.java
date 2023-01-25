package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.request.CommentReq;
import com.sixsense.liargame.api.response.CommentResp;

import java.util.List;

public interface CommentService {
    void insertComments(CommentReq commentReq);

    void deleteComment(Long id);

    void updateComment(Long id, CommentReq commentReq);

    List<CommentResp> selectArticle(Long articleId);
}
