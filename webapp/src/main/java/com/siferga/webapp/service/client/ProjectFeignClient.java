package com.siferga.webapp.service.client;

import com.siferga.webapp.model.Project;
import com.siferga.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "project")
public interface ProjectFeignClient {

    @PostMapping(value = "/api/createProject", consumes = "application/json")
    public Project createProject(Project project);

    @GetMapping(value = "/api/getAll",consumes = "application/json")
    public ResponseEntity<List<Project>> getAllProjects();

    @GetMapping(value = "/api/findProjectById",consumes = "application/json")
    public ResponseEntity<Project> findProjectById(@RequestParam Long id);

    @PutMapping(value = "/api/updateProject",consumes = "application/json")
    public String updateProject(@RequestParam Long id,Project project);

    @DeleteMapping(value = "/api/deleteProject",consumes = "application/json")
    public void deleteProject(@RequestParam Long id);
}
