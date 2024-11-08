package com.siferga.webapp.service.client;

import com.siferga.webapp.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "knowledge")
public interface KnowledgeFeignClient {
    @PostMapping(value = "/knowledge/saveKnowledge", consumes = "application/json")
    public ResponseEntity<String> saveKnowledge(@RequestParam("knowledge") MultipartFile knowledge, @RequestParam("userId") Long userId, @RequestParam("projectId") Long projectId);

    @GetMapping(value = "/knowledge/knowledgeBy/{knowledgeId}",consumes = "application/json")
    public ResponseEntity<byte[]> getKnowledgeById(@PathVariable String knowledgeId);

    @DeleteMapping(value = "/knowledge/deleteKnowledge/{knowledgeId}",consumes = "application/json")
    public void deleteKnowledge(@PathVariable String knowledgeId);
}
