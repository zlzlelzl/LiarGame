package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.service.CommentService;
import com.sixsense.liargame.db.entity.*;
import com.sixsense.liargame.db.repository.*;
import com.sixsense.liargame.api.request.CommentReq;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void insertComments(CommentReq commentReq) {
        Comment comment = Comment.builder()
                .comment(commentReq.getContent())
                .userId(commentReq.getUserId())
                .build();
        Long id = commentRepository.save(comment).getId();
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(Long id, CommentReq commentReq) {
        Comment comment = commentRepository.getOne(id);
        comment.setComment(commentReq.getContent());
        commentRepository.save(comment);
    }
}
