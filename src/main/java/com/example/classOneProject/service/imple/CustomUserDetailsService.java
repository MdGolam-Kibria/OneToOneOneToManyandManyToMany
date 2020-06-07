package com.example.classOneProject.service.imple;

import com.example.classOneProject.ForSpringSecurity.model.User;
import com.example.classOneProject.dto.UserPrinciple;
import com.example.classOneProject.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService ")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    public CustomUserDetailsService(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.get(userName);
        UserPrinciple userDetails = UserPrinciple.create(user);
        if (userDetails==null){
            throw new UsernameNotFoundException("UserName Not Found");
        }
        return userDetails;
    }
}
