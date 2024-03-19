package com.capg.CommunityService.service;

import com.capg.CommunityService.exceptions.PostNotFoundException;
import com.capg.CommunityService.exceptions.TimeLimitExceededException;
import com.capg.CommunityService.exceptions.UnauthorizedException;
import com.capg.CommunityService.model.Post;
import com.capg.CommunityService.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IPostService implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post, String userId) {
        post.setUserId(userId);
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(String postId, Post updatedPost, String userId) {
        Post existingPost = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found!"));
        if (!existingPost.getUserId().equals(userId)) {
            throw new UnauthorizedException("You are not authorized to update this post!");
        }
        if(isPast5Minutes(existingPost.getCreatedAt())) {
            throw new TimeLimitExceededException("You can only update the post within 5 minutes of creation!");
        }
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        return postRepository.save(existingPost);
    }
    @Override
    public void deletePost(String postId, String userId) {
        Post existingPost = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found!"));
        if(!existingPost.getUserId().equals(userId)) {
            throw new UnauthorizedException("You are not authorized to delete this post!");
        }
        postRepository.delete(existingPost);
    }

    private boolean isPast5Minutes(LocalDateTime createdAt) {
        LocalDateTime now = LocalDateTime.now();
        return now.minusMinutes(5).isAfter(createdAt);
    }
}
