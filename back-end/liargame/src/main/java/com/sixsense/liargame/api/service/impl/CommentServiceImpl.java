package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.service.CommentService;
import com.sixsense.liargame.db.entity.*;
import com.sixsense.liargame.db.repository.*;
import com.sixsense.liargame.api.request.CommentReq;
import com.sixsense.liargame.api.response.CommentResp;
import com.sixsense.liargame.common.model.response.UserDto;
import org.springframework.stereotype.Service;
import java.util.*;
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
    public List<CommentResp> insertComments(CommentReq commentReq) {

    }
}
