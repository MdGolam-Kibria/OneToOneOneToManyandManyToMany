package com.example.classOneProject.service;

import com.example.classOneProject.ForSpringSecurity.model.Role;
import com.example.classOneProject.ForSpringSecurity.model.User;
import com.example.classOneProject.repository.RoleRepository;
import com.example.classOneProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
public class DbInit {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${login.username}")
    private String username;
    @Value("${login.password}")
    private String password;


    public DbInit(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //@PostConstruct
    public void init() {


        String roleName = "ROLE_ADMIN";
        int roleExistCount = roleRepository.countByName(roleName);
        Role role = null;
        if (roleExistCount == 1) {
            role = roleRepository.findByName(roleName);
        } else {
            role = new Role();
            role.setName(roleName);
            role = roleRepository.save(role);
        }
        User user = userRepository.findByUsernameAndIsActiveTrue(username);
        if (user == null) {
            user = new User();
            user.setEmail("abc@ab.com");
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
        }
        user.setRoles(Arrays.asList(role));
        user = userRepository.save(user);
    }
}

