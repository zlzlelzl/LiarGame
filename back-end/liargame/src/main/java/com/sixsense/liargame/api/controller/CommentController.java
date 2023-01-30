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
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

//    @GetMapping("/{articleId}")
//    public ResponseEntity<List<CommentResp>> getComments(@PathVariable Long articleId) {
//        return ResponseEntity.ok().body(commentService.selectArticle(articleId));
//    }

    @PostMapping
    public ResponseEntity<CommentResp> insertComment(@RequestBody CommentReq commentReq) {
        commentService.insertComments(commentReq);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CommentResp> updateComment(@PathVariable Long id,  @RequestBody CommentReq commentReq) {
//        commentService.updateComment(id, commentReq);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<CommentResp> deleteComment(@PathVariable Long id){
//        commentService.deleteComment(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping
//    public List<CommentResp> getComments(@RequestBody CommentReq commentReq){
////        commentService.findAllComment();
//        return commentService.findAllComment();
//    }
}
