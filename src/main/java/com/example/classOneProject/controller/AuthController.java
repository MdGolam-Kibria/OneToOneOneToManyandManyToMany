package com.example.classOneProject.controller;

import com.example.classOneProject.annotation.ApiController;
import com.example.classOneProject.dto.LoginDto;
import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.service.AuthService;
import com.example.classOneProject.utill.UrlConstraint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApiController
@RequestMapping(UrlConstraint.AuthManagement.ROOT)
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(UrlConstraint.AuthManagement.LOGIN)
    public Responce loginWithJwt(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response){
            return authService.login(loginDto);
    }
}
