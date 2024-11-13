package org.siferga.knowledge.service;

import lombok.AllArgsConstructor;

import org.siferga.knowledge.entity.Knowledge;
import org.siferga.knowledge.repository.KnowledgeRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    public Knowledge saveKnowledge(Long userId,Long projectId, MultipartFile knowledge) throws Exception {
        byte[] content = knowledge.getBytes();

        Knowledge knowledgeEntity = new Knowledge(
                userId,
                projectId,
                knowledge.getOriginalFilename(),
                knowledge.getContentType(),
                content
        );
        return knowledgeRepository.save(knowledgeEntity);
    }

    public ResponseEntity<byte[]> getKnowledgeById(String knowledgeId) {
        Knowledge knowledge = knowledgeRepository.findById(knowledgeId).orElse(null);
        if (knowledge != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(knowledge.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\"" + knowledge.getFileName() + "\"")
                    .body(knowledge.getFile());
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    public String getKnowledgeFileType(String id) {
        return knowledgeRepository.findById(id).get().getContentType();
    }

    public void deleteKnowledge(String id) {
        Knowledge knowledge = knowledgeRepository.findById(id).orElse(null);
        assert knowledge != null;
        knowledgeRepository.delete(knowledge);
    }

    public List<Knowledge> findAllKnowledge() {
        return knowledgeRepository.findAll();
    }

}