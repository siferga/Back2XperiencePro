package com.siferga.webapp.service;

import com.siferga.webapp.model.User;
import com.siferga.webapp.service.client.CollaboratorFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final PasswordEncoder passwordEncoder;
    private final CollaboratorFeignClient patientFeignClient;

    @Override
    public User register(User user) {
//        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  patientFeignClient.createUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return patientFeignClient.findUserByEmail(email);
    }

}
