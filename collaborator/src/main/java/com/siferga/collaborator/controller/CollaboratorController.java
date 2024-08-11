package com.siferga.collaborator.controller;

import com.siferga.collaborator.service.CollaboratorService;
import com.siferga.collaborator.model.Collaborator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CollaboratorController {
    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    // Create a new patient
    @PostMapping("/createCollaborator")
    public Collaborator createPatient(@RequestBody Collaborator collaborator) {
        return collaboratorService.save(collaborator);
    }

    // Get a list with all patients
    @GetMapping("/getAll")
    public List<Collaborator> getAllCollaborators() {
        return collaboratorService.findAll();
    }

    // Get a single patient by ID
    @GetMapping("/findCollaboratorById")
    public ResponseEntity<Collaborator> getPatientById(@RequestParam Long id) {
        Optional<Collaborator> patient = collaboratorService.findById(id);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a collaborator
    @PutMapping("/updateCollaborator")
    public String updateCollaborator(@RequestParam(name = "id") Long id, @RequestBody Collaborator collaborator) {
        return collaboratorService.updateCollaborator(id,collaborator);
    }

    // Delete a patient
    @DeleteMapping("/deleteCollaborator")
    public void deleteCollaborator(@RequestParam(name = "id") Long id) {
        collaboratorService.deleteCollaborator(id);
    }


}
