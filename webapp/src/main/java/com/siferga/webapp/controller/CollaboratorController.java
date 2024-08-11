package com.siferga.webapp.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.webapp.service.CollaboratorServiceImpl;
import com.siferga.webapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import com.siferga.webapp.model.Collaborator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CollaboratorController {
    private final CollaboratorServiceImpl collaboratorServiceImpl;
    private final UserServiceImpl userServiceImpl;

    /*************************   ADD COLLABORATOR   *****************************/

    @GetMapping("/addCollaborator")
    public ModelAndView showAddCollaboratorForm() {
        return new ModelAndView("/collaborators/addCollaborator","collaborator",new Collaborator());
    }

    @PostMapping("/addCollaborator")
    public ModelAndView addNewCollaborator(@ModelAttribute Collaborator collaborator) {
        collaboratorServiceImpl.registerCollaborator(collaborator);
        return new ModelAndView("/collaborators/collaboratorList","collaborator",new Collaborator());
    }

    /**************************   COLLABORATOR LIST   *****************************/

    @GetMapping("/collaboratorList")
    public ModelAndView showCollaboratorList(Model model) {
        List<Collaborator> collaborators = collaboratorServiceImpl.findAllCollaborators();
        return new ModelAndView("collaborators/collaboratorList", "collaborators", collaborators);
    }

    @PostMapping("/collaboratorList")
    public ModelAndView showCollaboratorList(@ModelAttribute Collaborator collaborator) {
        List<Collaborator> patients = collaboratorServiceImpl.findAllCollaborators();
        ModelAndView modelAndView = new ModelAndView("collaborators/collaboratorList");
        modelAndView.addObject("collaborators", collaborator);
        modelAndView.addObject("collaborator", new Collaborator());
        return modelAndView;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Collaborator>> getAllCollaborators() {
        List<Collaborator> collaborators = collaboratorServiceImpl.findAllCollaborators();
        return ResponseEntity.ok(collaborators);
    }

    /***************************   FIND A PATIENT   ********************************/

    //getting users byID
    @PostMapping("findCollaboratorById")
    public Collaborator getCollaboratorById(@RequestParam Long id) {
        return this.collaboratorServiceImpl.findById(id);
    }

    /*************************   UPDATE A PATIENT   *****************************/

    @GetMapping ("/updateCollaborator/{id}")
    public ModelAndView updateCollaborator(@PathVariable Long id) {
        return new ModelAndView("/collaborators/updateCollaborator","collaborator",collaboratorServiceImpl.findById(id));
    }

    // Handle form submission for updating a specific patient
    @PostMapping("/updateCollaborator/{id}")
    public ModelAndView updateCollaborator(@PathVariable("id") Long id, @ModelAttribute("collaborator") Collaborator collaborator) {
        collaboratorServiceImpl.updateCollaborator(id, collaborator);
        return new ModelAndView ("/collaborators/updateCollaborator");
    }

    /*************************   DELETE A PATIENT   *****************************/

    // Show form for deleting a specific patient
    @GetMapping("/deleteCollaborator/{id}")
    public ModelAndView showDeleteCollaboratorForm(@PathVariable("id") Long id) {
        return new ModelAndView("/collaborators/deleteCollaborator","collaborator",collaboratorServiceImpl.findById(id));
    }

    // Deleting a patient
    @PostMapping("/deleteCollaborator/{id}")
    public ModelAndView deleteCollaborator(@PathVariable("id") Long id, @ModelAttribute("collaborator") Collaborator collaborator) {
        collaboratorServiceImpl.deleteCollaborator(id);
        return new ModelAndView("/collaborators/collaboratorList");
    }

}