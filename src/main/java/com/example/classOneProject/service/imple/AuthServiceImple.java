package com.example.classOneProject.service.imple;

import com.example.classOneProject.ForSpringSecurity.model.User;
import com.example.classOneProject.dto.LoginDto;
import com.example.classOneProject.dto.LoginResponceDto;
import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.filter.JwtTokenProvider;
import com.example.classOneProject.repository.UserRepository;
import com.example.classOneProject.service.AuthService;
import com.example.classOneProject.utill.ResponceBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImple implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImple(UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Responce login(LoginDto loginDto) {
        //at first check user present or not in database so...
        User user = userRepository.findByUsernameAndIsActiveTrue(loginDto.getUsername());
        if (user==null){
            return ResponceBuilder.getFailureResponce(HttpStatus.UNAUTHORIZED,"Invalid username or password");
        }
        /*
        jodi user null na hoi tahole user ke ekta responce dibo jetar moddhe ekta token thakbe so
         */
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
                //now check this "authentication" authenticate or not
        if (authentication.isAuthenticated()) {
            //jodi authenticate hoi tahole user ke amake ekta responce dite hobe so at first make a responce
            LoginResponceDto loginResponceDto = new LoginResponceDto();
            loginResponceDto.setToken(jwtTokenProvider.generateToken(authentication));
            loginResponceDto.setUsername(user.getUsername());
            return ResponceBuilder.getSuccessResponce(HttpStatus.OK,"LoggedIn success",loginResponceDto);
        }
        return ResponceBuilder.getFailureResponce(HttpStatus.BAD_REQUEST,"Invalid userName or passrord");
    }
}
