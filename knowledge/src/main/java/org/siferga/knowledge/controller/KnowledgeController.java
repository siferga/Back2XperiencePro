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
@RequestMapping(path = "/knowledge", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    // Add a knowledge
    @PostMapping("/addKnowledge")
    public ResponseEntity<Knowledge> addKnowledge(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("userId") Long userId,
                                                  @RequestParam("projectId") Long projectId) throws Exception {
        Knowledge knowledge = knowledgeService.saveKnowledge(file, userId, projectId);
        return ResponseEntity.ok(knowledge);
    }

//    //Upload knowledge
//    @PostMapping("/saveKnowledge")
//    public ResponseEntity<String> saveKnowledge(@RequestParam("knowledge") MultipartFile knowledge, @RequestParam("userId") Long userId, @RequestParam("projectId") Long projectId) throws Exception {
//        Knowledge saveKnowledge = knowledgeService.saveKnowledge(knowledge, userId, projectId);
//        return ResponseEntity.ok("document sauvegardé");
//    }

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