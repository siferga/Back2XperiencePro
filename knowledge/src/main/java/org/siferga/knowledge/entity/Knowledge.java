package org.siferga.knowledge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
@Document(collection = "Knowledge")
public class Knowledge {
    @Id
    private String id;
    private Long userId;
    private Long projectId;
    private String fileName;
    private String contentType;
    @CreatedDate
    private Date date;
    private byte[] file;

    public Knowledge(Long userId, Long projectId,String fileName, String contentType, byte[] file) {
        this.userId = userId;
        this.projectId = projectId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.date = new Date();
        this.file = file;

    }
}