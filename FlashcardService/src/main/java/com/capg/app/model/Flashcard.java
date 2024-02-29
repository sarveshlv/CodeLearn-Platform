package com.capg.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "flashcard")
public class Flashcard {

    @Id
    private String id;
    private String question;
    private String description;
    private String category;

}
