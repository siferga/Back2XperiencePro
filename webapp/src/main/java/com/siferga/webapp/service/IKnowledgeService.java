package com.siferga.webapp.service;

import com.siferga.webapp.model.Knowledge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IKnowledgeService {

    ResponseEntity<String> registerKnowledge(MultipartFile knowledge, Long userId, Long projectId);

    List<Knowledge> findAllKnowledges();

    ResponseEntity<byte[]> findKnowledgeById(String id);

    void deleteKnowledge(String id);
}
