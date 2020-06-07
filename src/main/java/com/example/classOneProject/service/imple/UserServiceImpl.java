package com.example.classOneProject.service.imple;

import com.example.classOneProject.ForSpringSecurity.model.User;
import com.example.classOneProject.repository.UserRepository;
import com.example.classOneProject.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User get(String username) {
        return userRepository.findByUsernameAndIsActiveTrue(username);
    }
}
