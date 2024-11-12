package com.siferga.webapp.controller;

import com.siferga.webapp.model.Collaborator;
import com.siferga.webapp.service.CollaboratorServiceImpl;
import com.siferga.webapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import com.siferga.webapp.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController
{
    private final UserServiceImpl userServiceImpl;
    private final CollaboratorServiceImpl collaboratorServiceImpl;

//    @GetMapping("/")
//    public ModelAndView home() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
//            // L'utilisateur est authentifié
//            return new ModelAndView("dashboardCollaborator");
//        } else {
//            // L'utilisateur n'est pas authentifié, redirection vers la page de login
//            return new ModelAndView("redirect:/login");
//        }
//    }

    @GetMapping("/")
    public ModelAndView home(Model model) {
      List<Collaborator> collaborators= (collaboratorServiceImpl.findAllCollaborators());
      model.addAttribute("collaborators", collaborators);
        return new ModelAndView("dashboardUser");
    }
    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("/signin");
    }
    @GetMapping ("/logOut")
    public String logOut(){
        return "signin";
    }

    /*********************************** SIGNUP ******************************************/

    @PostMapping("/signup")
    public ModelAndView registerUser(@ModelAttribute User user) {
        userServiceImpl.register(user);
        return new ModelAndView("/signin");
        //return "redirect:/signin?success";
    }

    @GetMapping ("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("/signup","user",new User());
    }

}
