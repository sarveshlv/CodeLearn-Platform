package com.capg.CommunityService.service;

import com.capg.CommunityService.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post, String userId);

    List<Post> getAllPosts();

    Post updatePost(String postId, Post updatedPost, String userId);

    void deletePost(String postId, String userId);
}
