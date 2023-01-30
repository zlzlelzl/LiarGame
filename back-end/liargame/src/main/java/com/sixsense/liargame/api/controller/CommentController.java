package com.sixsense.liargame.api.controller;

import com.sixsense.liargame.api.request.CommentReq;
import com.sixsense.liargame.api.response.CommentResp;
import com.sixsense.liargame.api.service.CommentService;
import com.sixsense.liargame.common.model.request.CommentDto;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/{articleId}/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public Long insertComment(@PathVariable("articleId") Long articleId, @RequestBody CommentReq commentReq) {
        return commentService.insertComments(articleId, commentReq);
    }

    @PatchMapping("/{commentid}")
    public ResponseEntity<?> updateComment(@PathVariable("commentid") Long id,  @RequestBody CommentReq commentReq) {
        commentService.updateComment(id, commentReq);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentid}")
    public ResponseEntity<CommentResp> deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping
//    public List<CommentResp> findAllComments() {
////        commentService.findAllComments(articleId);
//        return commentService.findAllComments();
//    }
}
