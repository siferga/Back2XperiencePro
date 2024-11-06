package com.siferga.webapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Long id;
    private String ref;
    private Client client;
    private String label;
    private String description;
    private Date startDate;
    private Date endDate;
}

