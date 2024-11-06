package com.siferga.webapp.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
//    private UserRole role;

}



