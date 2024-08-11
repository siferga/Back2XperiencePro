package com.siferga.collaborator.controller;


import com.siferga.collaborator.model.User;
import com.siferga.collaborator.service.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.registration(user);
    }

    @PostMapping("/findByEmail")
    public User getUserByEmail(@RequestBody String email) {
        return userServiceImpl.findUserByEmail(email);
    }

}
