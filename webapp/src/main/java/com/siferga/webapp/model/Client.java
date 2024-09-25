package com.siferga.webapp.model;

import jakarta.persistence.*;

import java.util.Set;

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInfo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;  // Association avec la classe User

    @OneToMany(mappedBy = "client")
    private Set<Project> projects;  // Association avec les projets
}
