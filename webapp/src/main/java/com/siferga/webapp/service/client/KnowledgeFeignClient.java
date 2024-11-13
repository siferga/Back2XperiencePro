package com.siferga.webapp.service.client;

import com.siferga.webapp.model.Knowledge;
import com.siferga.webapp.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "knowledge")
public interface KnowledgeFeignClient {
    @PostMapping(value = "/knowledge/addKnowledge", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveKnowledge(@RequestParam("userId") Long userId,
                                                @RequestParam("projectId") Long projectId,
                                                @RequestPart("file") MultipartFile file);

    @GetMapping(value = "/knowledge/allKnowledge",consumes = "application/json")
    public ResponseEntity<List<Knowledge>> getAllKnowledge();

    @GetMapping(value = "/knowledge/knowledgeBy/{id}",consumes = "application/json")
    public ResponseEntity<byte[]> getKnowledgeById(@PathVariable String id);

    @DeleteMapping(value = "/knowledge/deleteKnowledge/{id}",consumes = "application/json")
    public void deleteKnowledge(@PathVariable String id);

}
