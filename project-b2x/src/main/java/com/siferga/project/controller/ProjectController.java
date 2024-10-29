package com.siferga.project.controller;

import com.siferga.project.model.Project;
import com.siferga.project.service.ProjectService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    // Create a new project
    @PostMapping("/createProject")
    public Project createProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    // Get a list with all projects
    @GetMapping("/getAll")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    // Get a single project by ID
    @GetMapping("/findProjectById")
    public ResponseEntity<Project> getCollaboratorById(@RequestParam Long id) {
        Optional<Project> project = projectService.findById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a project
    @PutMapping("/updateProject")
    public String updateProject(@RequestParam(name = "id") Long id, @RequestBody Project project) {
        return projectService.updateProject(id,project);
    }

    // Delete a project
    @DeleteMapping("/deleteProject")
    public void deleteProject(@RequestParam(name = "id") Long id) {
        projectService.deleteProject(id);
    }

    @GetMapping("/projectDetails/{id}")
    public String getProjectDetails(@PathVariable("id") Long id, Project project) {
        projectService.findAll();
        return "projects/projectDetails";
    }



}
