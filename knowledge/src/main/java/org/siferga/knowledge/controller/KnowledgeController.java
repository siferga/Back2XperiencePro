package org.siferga.knowledge.controller;

import lombok.AllArgsConstructor;
import org.siferga.knowledge.entity.Knowledge;
import org.siferga.knowledge.service.KnowledgeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/knowledge")
@AllArgsConstructor
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    //Upload knowledge
    @PostMapping("/saveKnowledge")
    public ResponseEntity<String> saveKnowledge(@RequestParam("knowledge") MultipartFile knowledge, @RequestParam("userId") Long userId, @RequestParam("projectId") Long projectId) throws Exception {
        Knowledge saveKnowledge = knowledgeService.saveKnowledge(knowledge, userId, projectId);
        return ResponseEntity.ok("document sauvegardé");
    }

    @GetMapping("/knowledgeBy/{knowledgeId}")
    public ResponseEntity<byte[]> getKnowledgeById(@PathVariable String knowledgeId) {
        return knowledgeService.getKnowledgeById(knowledgeId);
    }

     @DeleteMapping("/deleteKnowledge/{knowledgeId}")
    public void deleteKnowledge(@PathVariable String knowledgeId) {
        knowledgeService.deleteKnowledge(knowledgeId);
    }
}