package com.capg.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "useractivity")
public class UserActivity {

    @Id
    private String id;
    private String userid;
    private String cardid;
    private String status;
    private String type;

}
