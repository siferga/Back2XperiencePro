package com.siferga.collaborator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "authorities",
            joinColumns = @JoinColumn(
                    name = "email",
                    referencedColumnName = "email",
                    columnDefinition = "VARCHAR(255)")
    )
    @Enumerated(EnumType.STRING)
    private List<UserRole> authorities;
    @Column(unique = true)
    private String email;
    private String password;

}
