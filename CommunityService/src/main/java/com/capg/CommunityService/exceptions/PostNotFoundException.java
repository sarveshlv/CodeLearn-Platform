package com.capg.CommunityService.exceptions;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(String msg) {
        super(msg);
    }
}
