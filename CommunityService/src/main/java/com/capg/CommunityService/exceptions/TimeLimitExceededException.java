package com.capg.CommunityService.exceptions;



public class TimeLimitExceededException extends RuntimeException{
    public TimeLimitExceededException(String msg) {
        super(msg);
    }
}
