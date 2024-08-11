package com.siferga.webapp.model;
import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
    // Example of Role enum, you can customize it as per your requirement
    public enum Role {
        ADMIN, USER, GUEST
    }
}
