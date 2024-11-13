package com.siferga.webapp.config;

import com.siferga.webapp.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/css/bootstrap.min.css","/css/style.css","/images/**","/signup","/login").permitAll()
                        // Pages accessibles uniquement aux administrateurs
                        .requestMatchers("/admin/**").hasRole("ADMINISTRATOR")

                        // Pages accessibles aux chefs de projet et aux administrateurs
                        .requestMatchers("/project/**").hasAnyRole("PROJECT_MANAGER", "ADMINISTRATOR")

                        // Pages accessibles aux collaborateurs, chefs de projet et administrateurs
                        .requestMatchers("/collaborator/**").hasAnyRole("COLLABORATOR", "PROJECT_MANAGER", "ADMINISTRATOR")

                        // Tout autre accès nécessite une authentification
                        .anyRequest().authenticated()) // Other pages need authentification
                .formLogin(form -> form.loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return  authenticationManagerBuilder.build();
    }


}
