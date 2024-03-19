package com.capg.CommunityService.service;

import com.capg.CommunityService.model.Comment;
import com.capg.CommunityService.model.Post;

public interface CommentService {

    Comment addCommentToPost(String postId, Comment comment, String userId);

    Comment addReplyToComment(String commentId, Comment reply, String userId);

    Comment updateComment(String commentId, Comment updatedComment, String userId);

    void deleteComment(String commentId, String userId);
}
