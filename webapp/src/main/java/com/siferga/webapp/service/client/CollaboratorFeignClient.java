package com.siferga.webapp.service.client;

import com.siferga.webapp.model.Collaborator;
import com.siferga.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "collaborator")
public interface CollaboratorFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/api/createUser", consumes = "application/json")
    public User createUser(@RequestBody User user);

    @RequestMapping (method = RequestMethod.POST, value = "/api/findByEmail",consumes = "application/json")
    public User findUserByEmail(@RequestBody String email);

    @PostMapping(value = "/api/createCollaborator", consumes = "application/json")
    public Collaborator createCollaborator(Collaborator collaborator);

    @GetMapping(value = "/api/getAll",consumes = "application/json")
    public ResponseEntity<List<Collaborator>> getAllCollaborators();

    @GetMapping(value = "/api/findCollaboratorById",consumes = "application/json")
    public ResponseEntity<Collaborator> findCollaboratorById(@RequestParam Long id);

    @PutMapping(value = "/api/updateCollaborator",consumes = "application/json")
    public String updateCollaborator(@RequestParam Long id,Collaborator patient);

    @DeleteMapping(value = "/api/deleteCollaborator",consumes = "application/json")
    public void deleteCollaborator(@RequestParam Long id);


}
