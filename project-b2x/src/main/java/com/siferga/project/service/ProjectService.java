package com.siferga.project.service;

import com.siferga.project.model.Project;
import com.siferga.project.repository.ProjectRepository;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ProjectService {
    private final ProjectRepository projectRepository;


    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

//    public String updateProject(Long id, Project project) {
//        projectRepository.findById(id).get().getEmail().equals(project.getId());
//        projectRepository.save(project);
//        return "Project updated";
//
//    }

    public String updateProject(Long id, Project updatedProject) {
        // Check if the project exists before updating
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            // Ensure that the ID from the request matches the one from the database
            Project projectToUpdate = existingProject.get();
            if (projectToUpdate.getId().equals(updatedProject.getId())) {
                projectRepository.save(updatedProject);
                return "Project updated";
            } else {
                return "Project ID mismatch";
            }
        } else {
            return "Project not found";
        }
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
