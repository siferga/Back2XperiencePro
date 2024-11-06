package com.siferga.webapp.service;

import com.siferga.webapp.model.Project;
import com.siferga.webapp.service.client.ProjectFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl  implements IProjectService {

    private final ProjectFeignClient projectFeignClient;

    /*************************   REGISTER PROJECT   *****************************/

    @Override
    public Project registerProject(Project project) {
        project.setLabel(project.getLabel());
        project.setDescription(project.getDescription());
        project.setClient(project.getClient());
        return projectFeignClient.createProject(project);
    }

    /*************************   FIND ALL PROJECTS   *****************************/

    @Override
    public List<Project> findAllProjects() {
        return projectFeignClient.getAllProjects().getBody();
    }

    /*************************   FIND PROJECT BY ID   *****************************/

    @Override
    public Project findById(Long id) {
        return projectFeignClient.findProjectById(id).getBody();
    }

    /*************************   UPDATE PROJECT   *****************************/

    @Override
    public Project updateProject(Long id, Project updatedProject) {
        ResponseEntity<Project> responseEntity = projectFeignClient.findProjectById(id);
        Project project = responseEntity.getBody();

        // Update project fields
        project.setLabel(updatedProject.getLabel());
        project.setDescription(updatedProject.getDescription());
        project.setClient(updatedProject.getClient());

        // Save the updated project using the Feign client
        return projectFeignClient.createProject(project);
    }

    /*************************   DELETE PROJECT   *****************************/

    @Override
    public void deleteProject(Long id) {
        projectFeignClient.deleteProject(id);
    }


}
