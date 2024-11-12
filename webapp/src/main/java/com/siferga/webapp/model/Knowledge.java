package com.siferga.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Knowledge {
    private String id;
    private Long userId;
    private Long projectId;
    private String fileName;
    private String contentType;
    private Date date;
    private byte[] file;
}
