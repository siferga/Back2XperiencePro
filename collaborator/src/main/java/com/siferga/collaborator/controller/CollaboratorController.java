package com.siferga.collaborator.controller;

import com.siferga.collaborator.service.CollaboratorService;
import com.siferga.collaborator.model.Collaborator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

    // Create a new collaborator
    @PostMapping("/createCollaborator")
    public Collaborator createCollaborator(@RequestBody Collaborator collaborator) {
        return collaboratorService.save(collaborator);
    }

    // Get a list with all collaborators
    @GetMapping("/getAll")
    public List<Collaborator> getAllCollaborators() {
        return collaboratorService.findAll();
    }

    // Get a single collaborator by ID
    @GetMapping("/findCollaboratorById")
    public ResponseEntity<Collaborator> getCollaboratorById(@RequestParam Long id) {
        Optional<Collaborator> collaborator = collaboratorService.findById(id);
        return collaborator.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a collaborator
    @PutMapping("/updateCollaborator")
    public String updateCollaborator(@RequestParam(name = "id") Long id, @RequestBody Collaborator collaborator) {
        return collaboratorService.updateCollaborator(id,collaborator);
    }

    // Delete a collaborator
    @DeleteMapping("/deleteCollaborator")
    public void deleteCollaborator(@RequestParam(name = "id") Long id) {
        collaboratorService.deleteCollaborator(id);
    }

    @GetMapping("/collaboratorDetails/{id}")
    public String getCollaboratorDetails(@PathVariable("id") Long id, Collaborator collaborator) {
        collaboratorService.findAll();
        return "collaborators/collaboratorDetails";
    }
//@GetMapping("/collaboratorDetails/{id}")
//public String getCollaboratorDetails(@PathVariable("id") Long id, Model model) {
//    Optional<Collaborator> collaborator = collaboratorService.findById(id);
//    if (collaborator.isPresent()) {
//        model.addAttribute("collaborator", collaborator.get());
//        return "collaborators/collaboratorDetails"; // chemin vers la vue Thymeleaf
//    } else {
//        return "redirect:/collaboratorList"; // redirection en cas d'absence
//    }
//}

}
