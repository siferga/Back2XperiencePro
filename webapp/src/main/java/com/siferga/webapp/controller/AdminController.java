package com.siferga.webapp.controller;

import com.siferga.webapp.model.Collaborator;
import com.siferga.webapp.service.CollaboratorServiceImpl;
import com.siferga.webapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final CollaboratorServiceImpl collaboratorServiceImpl;
//    private final AdminServiceImpl adminService;

    // Displays the registration form for a new user
    @GetMapping("/admin/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("admin/signup", "collaborator", new Collaborator());
    }

    // Handles form submission for user registration
    @PostMapping("/admin/signup")
    public ModelAndView registerUser(@ModelAttribute Collaborator collaborator) {
        try {
            collaboratorServiceImpl.registerCollaborator(collaborator);
            return new ModelAndView("redirect:/admin/signup?success");
        } catch (Exception e) {
            return new ModelAndView("redirect:/admin/signup?error");
        }
    }

//    @PostMapping("admin/signup")
//    public ModelAndView registerUser(@ModelAttribute Collaborator collaborator) {
//
//        collaboratorServiceImpl.registerCollaborator(collaborator);
//        return new ModelAndView("new_collaborator_message");
//    }

//    @PostMapping("/admin/signup")
//    public ModelAndView registerCollaborator(@ModelAttribute Collaborator collaborator) {
//        adminService.registerCollaborator(collaborator);
//        return new ModelAndView("redirect:/admin/signup?success");
//    }

}


