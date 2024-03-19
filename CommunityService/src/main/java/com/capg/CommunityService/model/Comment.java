package com.capg.CommunityService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;
    private String text;
    private String userId;
    private List<Comment> replies;
    private LocalDateTime createdAt;
}
