package com.capg.CommunityService.service;

import com.capg.CommunityService.exceptions.CommentNotFoundException;
import com.capg.CommunityService.exceptions.PostNotFoundException;
import com.capg.CommunityService.exceptions.TimeLimitExceededException;
import com.capg.CommunityService.exceptions.UnauthorizedException;
import com.capg.CommunityService.model.Comment;
import com.capg.CommunityService.model.Post;
import com.capg.CommunityService.repository.CommentRepository;
import com.capg.CommunityService.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ICommentService implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment addCommentToPost(String postId, Comment comment, String userId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found!"));
        comment.setUserId(userId);
        comment.setCreatedAt(LocalDateTime.now());
        if(post.getComments() == null) {
            post.setComments(new ArrayList<>());
        }
        post.getComments().add(comment);
        postRepository.save(post);
        return commentRepository.save(comment);
    }

    @Override
    public Comment addReplyToComment(String commentId, Comment reply, String userId) {
        Comment comment  = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("Comment not found!"));
        reply.setUserId(userId);
        reply.setCreatedAt(LocalDateTime.now());
        if(comment.getReplies() == null) {
            comment.setReplies(new ArrayList<>());
        }
        comment.getReplies().add(reply);
        commentRepository.save(comment);
        return commentRepository.save(comment);
    }
    @Override
    public Comment updateComment(String commentId, Comment updatedComment, String userId) {
        Comment existingComment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("Comment not found!"));
        if(!existingComment.getUserId().equals(userId)) {
            throw new UnauthorizedException("You are not authorized to update this comment!");
        }
        if(isPast5Minutes(existingComment.getCreatedAt())) {
            throw new TimeLimitExceededException("You can only update the comment within 5 minutes of creation!");
        }
        existingComment.setText(updatedComment.getText());
        return commentRepository.save(existingComment);
    }
    @Override
    public void deleteComment(String commentId, String userId) {
        Comment existingComment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("Comment not found!"));
        if(!existingComment.getUserId().equals(userId)) {
            throw new UnauthorizedException("You are not authorized to update this comment!");
        }
        commentRepository.delete(existingComment);
    }

    private Boolean isPast5Minutes(LocalDateTime createdAt) {
        LocalDateTime now = LocalDateTime.now();
        return now.minusMinutes(5).isAfter(createdAt);
    }

}
