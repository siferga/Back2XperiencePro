package com.siferga.webapp.service;

import com.siferga.webapp.service.client.CollaboratorFeignClient;
import lombok.AllArgsConstructor;
import com.siferga.webapp.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final PasswordEncoder passwordEncoder;
    private final CollaboratorFeignClient collaboratorFeignClient;

    @Override
    public User register(User user) {
        List<String>authorities = new ArrayList<>();
//        authorities.add("ADMIN");
//        authorities.add("MANAGER");
        authorities.add("COLLABORATOR");
        user.setAuthorities(authorities);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  collaboratorFeignClient.createUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return collaboratorFeignClient.findUserByEmail(email);
    }

}
