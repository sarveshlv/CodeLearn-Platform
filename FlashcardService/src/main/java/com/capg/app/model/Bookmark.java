package com.capg.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bookmarks")
public class Bookmark {

    @Id
    private String id;
    private String cardId;
}
