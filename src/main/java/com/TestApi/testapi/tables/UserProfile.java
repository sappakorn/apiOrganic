package com.TestApi.testapi.tables;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user-profile")
public class UserProfile {
    private String username;
    private String password;
}
