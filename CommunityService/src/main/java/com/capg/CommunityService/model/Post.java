package com.capg.CommunityService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String title;
    private String content;
    private String userId;
    private List<Comment> comments;
    private LocalDateTime createdAt;

}
