package com.siferga.webapp.service;

import com.siferga.webapp.model.Knowledge;
import com.siferga.webapp.service.client.KnowledgeFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class KnowledgeServiceImpl implements IKnowledgeService {

    private final KnowledgeFeignClient knowledgeFeignClient;
    /*************************   REGISTER PROJECT   *****************************/

    @Override
    public ResponseEntity<String> registerKnowledge(Long userId, Long projectId, MultipartFile file) {

        return knowledgeFeignClient.saveKnowledge(userId, projectId, file);
    }

    /*************************   FIND ALL KNOWLEDGES   *****************************/

    @Override
    public List<Knowledge> findAllKnowledges() {
        return knowledgeFeignClient.getAllKnowledge().getBody();
    }

    /*************************   FIND PROJECT BY ID   *****************************/

    @Override
    public ResponseEntity<byte[]> findKnowledgeById(String id) {
        return knowledgeFeignClient.getKnowledgeById(id);
    }

    /*************************   DELETE PROJECT   *****************************/

    @Override
    public void deleteKnowledge(String id) {
        knowledgeFeignClient.deleteKnowledge(id);
    }


}
