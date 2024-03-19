package com.capg.CommunityService.controller;

import com.capg.CommunityService.model.Comment;
import com.capg.CommunityService.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<Comment> addCommentToPost(@PathVariable String postId, @RequestBody Comment comment, @RequestHeader("userId") String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.addCommentToPost(postId, comment, userId));
    }
    @PostMapping("/reply/{commentId}")
    public ResponseEntity<Comment> addReplyToComment(@PathVariable String commentId, @RequestBody Comment reply, @RequestHeader("userId") String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.addReplyToComment(commentId, reply, userId));
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable String commentId, @RequestBody Comment comment, @RequestHeader("userId") String userId) {
        return ResponseEntity.ok(commentService.updateComment(commentId, comment, userId));
    }
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable String commentId, @RequestHeader("userId") String userId) {
        commentService.deleteComment(commentId, userId);
        return ResponseEntity.noContent().build();
    }
}
