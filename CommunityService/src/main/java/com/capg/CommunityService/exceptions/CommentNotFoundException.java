package com.capg.CommunityService.exceptions;

import com.capg.CommunityService.service.CommentService;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(String msg) {
        super(msg);
    }
}
