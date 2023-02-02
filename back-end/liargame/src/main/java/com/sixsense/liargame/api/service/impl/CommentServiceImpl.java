package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.request.CommentReq;
import com.sixsense.liargame.api.response.CommentResp;
import com.sixsense.liargame.api.service.CommentService;
import com.sixsense.liargame.db.entity.Comment;
import com.sixsense.liargame.db.repository.CommentRepository;
import com.sixsense.liargame.db.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long insertComments(Long articleId, CommentReq commentReq) {
        Comment comment = commentRepository.save(commentReq.commentToEntity(articleId));
        return comment.getId();
    }

    @Override
    public Long deleteComment(Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    @Override
    public Long updateComment(Long articleId, Long commentId, CommentReq commentReq) {
        Comment comment = commentRepository.findByArticleIdAndCommentId(articleId, commentId);
        comment.updateComment(commentReq.getCommentContent());
        commentRepository.save(comment);
        return commentId;
    }

    @Override
    public List<CommentResp> findAllComments(Long articleId, Pageable pageable) {
        PageRequest pageRequest = (PageRequest) pageable;
        Sort sort = Sort.by(Sort.Direction.DESC, "updatedAt");
        pageRequest.withSort(sort);
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        System.out.println(comments);
        return comments.stream().map(CommentResp::new).collect(Collectors.toList());
    }

    public List<Comment> findAllByArticleId(Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        System.out.println(comments);
        return comments;
    }
}
