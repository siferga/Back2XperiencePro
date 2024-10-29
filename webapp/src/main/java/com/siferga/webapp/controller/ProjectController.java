package com.siferga.webapp.controller;

import com.siferga.webapp.model.Collaborator;
import com.siferga.webapp.model.Project;
import com.siferga.webapp.service.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    /*************************   ADD PROJECT   *****************************/

    @GetMapping("/addProject")
    public ModelAndView showAddProjectForm() {
        return new ModelAndView("/projects/addProject", "project", new Project());
    }

    @PostMapping("/addProject")
    public ModelAndView addNewProject(@ModelAttribute Project project) {
        projectServiceImpl.registerProject(project);
        return new ModelAndView("/projects/projectList", "project", new Project());
    }

    /**************************   PROJECT LIST   *****************************/

    @GetMapping("/projectList")
    public ModelAndView showProjectList(Model model) {
        List<Project> projects = projectServiceImpl.findAllProjects();
        return new ModelAndView("projects/projectList", "projects", projects);
    }

    @PostMapping("/projectList")
    public ModelAndView showProjectList(@ModelAttribute Project project) {
        List<Project> projects = projectServiceImpl.findAllProjects();
        ModelAndView modelAndView = new ModelAndView("projects/projectList");
        modelAndView.addObject("projects", projects);
        modelAndView.addObject("project", new Project());
        return modelAndView;
    }

    @GetMapping("/findAllProjects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectServiceImpl.findAllProjects();
        return ResponseEntity.ok(projects);
    }

    /***************************   FIND A PROJECT   ********************************/

    @PostMapping("/findProjectById")
    public Project getProjectById(@RequestParam Long id) {
        return this.projectServiceImpl.findById(id);
    }

    /*************************   UPDATE A PROJECT   *****************************/

    @GetMapping("/updateProject/{id}")
    public ModelAndView updateProject(@PathVariable Long id) {
        return new ModelAndView("projects/updateProject", "project", projectServiceImpl.findById(id));
    }

    @PostMapping("/updateProject/{id}")
    public ModelAndView updateProject(@PathVariable("id") Long id, @ModelAttribute("project") Project project) {
        projectServiceImpl.updateProject(id, project);
        return new ModelAndView("projects/projectDetails");
    }

    /*************************   DELETE A PROJECT   *****************************/

    @GetMapping("/deleteProject/{id}")
    public ModelAndView showDeleteProjectForm(@PathVariable("id") Long id) {
        return new ModelAndView("projects/deleteProject", "project", projectServiceImpl.findById(id));
    }

    @PostMapping("/deleteProject/{id}")
    public ModelAndView deleteProject(@PathVariable("id") Long id) {
        projectServiceImpl.deleteProject(id);
        return new ModelAndView("projects/projectList");
    }

    /*************************   PROJECT DETAILS   *****************************/
    @GetMapping("/projectDetails/{id}")
    public String viewProjectDetails(@PathVariable("id") Long id, Model model) {
        Project project = projectServiceImpl.findById(id);
        if (project != null) {
            model.addAttribute("project", project);
            return "projects/projectDetails";  // Retourne la vue des détails du collaborateur
        }else {
            return "redirect:/projects/projectList";
        }
    }

}
