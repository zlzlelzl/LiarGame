package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.response.CommentResp;
import com.sixsense.liargame.api.service.CommentService;
import com.sixsense.liargame.db.entity.*;
import com.sixsense.liargame.db.repository.*;
import com.sixsense.liargame.api.request.CommentReq;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
                .commentWriter()
                .build();
        Long id = commentRepository.save(comment).getId();
    }

//    @Override
//    public void deleteComment(Long id) {
//        commentRepository.deleteById(id);
//    }
//
//    @Override
//    public void updateComment(Long id, CommentReq commentReq) {
//        Comment comment = commentRepository.getOne(id);
//        comment.setComment(commentReq.getContent());
//        commentRepository.save(comment);
//    }
//
//    @Override
//    public List<CommentResp> findAllComment(){
//        Sort sort = Sort.by(Sort.Direction.DESC, "id", "updatedAt");
//        List<Comment> comments = commentRepository.findAll(sort);
//        return comments.stream().map(CommentResp::new).collect(Collectors.toList());
//    }
}
