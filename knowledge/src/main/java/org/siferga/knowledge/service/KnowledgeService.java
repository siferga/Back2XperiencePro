package org.siferga.knowledge.service;

import lombok.AllArgsConstructor;

import org.siferga.knowledge.entity.Knowledge;
import org.siferga.knowledge.repository.KnowledgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    public Knowledge addKnowledge(Knowledge knowledge) {
        return knowledgeRepository.save(knowledge);
    }

    public List<Knowledge> getAllKnowledges() {
        return knowledgeRepository.findAll();
    }

    public Optional<Knowledge> getKnowledgeById(String id) {
        return knowledgeRepository.findById(id);
    }

    public void deleteKnowledge(String id) {
        Knowledge knowledge = getKnowledgeById(id).get();
        knowledgeRepository.delete(knowledge);
    }
}