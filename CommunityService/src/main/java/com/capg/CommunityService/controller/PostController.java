package com.capg.CommunityService.controller;

import com.capg.CommunityService.model.Post;
import com.capg.CommunityService.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @RequestHeader("userId") String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(post, userId));
    }
    @GetMapping("/getALlPosts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }
    @PutMapping("/update/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable String postId, @RequestBody Post post, @RequestHeader("userId") String userId) {
        return ResponseEntity.ok(postService.updatePost(postId, post, userId));
    }
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable String postId, @RequestHeader("userId") String userId) {
        postService.deletePost(postId, userId);
        return ResponseEntity.noContent().build();
    }
}
