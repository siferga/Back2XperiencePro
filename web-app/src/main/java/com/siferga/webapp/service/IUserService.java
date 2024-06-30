package com.siferga.webapp.service;

import com.siferga.webapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User register(User user);

    public User findByEmail(String email);

}
