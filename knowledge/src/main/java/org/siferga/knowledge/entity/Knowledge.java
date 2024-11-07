package org.siferga.knowledge.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
@Document(collection = "Knowledge")
public class Knowledge {
    @Id
    private String id;
    private Long userId;
    private Long collaboratorId;
    private String collaboratorName;
    private LocalDate date;
    private String Knowledge;
}