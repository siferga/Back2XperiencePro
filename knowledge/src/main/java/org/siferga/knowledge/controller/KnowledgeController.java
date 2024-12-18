package org.siferga.knowledge.controller;

import lombok.AllArgsConstructor;
import org.siferga.knowledge.entity.Knowledge;
import org.siferga.knowledge.service.KnowledgeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/knowledge")
@Validated
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    // Add a knowledge
    @PostMapping("/addKnowledge")
    public ResponseEntity<Knowledge> addKnowledge(@RequestParam("userId") Long userId,
                                                  @RequestParam("projectId") Long projectId,
                                                  @RequestPart("file") MultipartFile file) throws Exception {
        Knowledge knowledge = knowledgeService.saveKnowledge(userId, projectId, file);
        return ResponseEntity.ok(knowledge);
    }

    // List of knowledges
    @GetMapping("/allKnowledge")
    public ResponseEntity<List<Knowledge>> getAllKnowledge() {
        List<Knowledge> knowledges = knowledgeService.findAllKnowledge();
        return ResponseEntity.ok(knowledges);
    }


    @GetMapping("/knowledgeBy/{id}")
    public ResponseEntity<byte[]> getKnowledgeById(@PathVariable String id) {
        return knowledgeService.getKnowledgeById(id);
    }


     @DeleteMapping("/deleteKnowledge/{id}")
    public void deleteKnowledge(@PathVariable String id) {
        knowledgeService.deleteKnowledge(id);
    }
}