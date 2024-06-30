package com.siferga.webapp.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.webapp.model.User;
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
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final CollaboratorServiceImpl collaboratorServiceImpl;

    @GetMapping("/")
    public ModelAndView home(Model model) {
        return new ModelAndView("index");
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
