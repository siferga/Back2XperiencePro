package org.siferga.knowledge.controller;

import lombok.AllArgsConstructor;
import org.siferga.knowledge.entity.Knowledge;
import org.siferga.knowledge.service.KnowledgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    @PostMapping("/addKnowledge")
    public Knowledge addKnowledge(@RequestBody Knowledge knowledge) {
        return knowledgeService.addKnowledge(knowledge);
    }

    @GetMapping("/knowledgeBy/{id}")
    public Optional<Knowledge> getKnowledgeById(@PathVariable String id) {
        return knowledgeService.getKnowledgeById(id);
    }

    @GetMapping("/allKnowledge")
    public List<Knowledge> allNote() {
        return knowledgeService.getAllKnowledges();
    }

     @DeleteMapping("/deleteKnowledge/{id}")
    public void deleteKnowledge(@PathVariable String id) {
        knowledgeService.deleteKnowledge(id);
    }
}