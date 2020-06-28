package com.example.classOneProject.service;

import com.example.classOneProject.dto.LoginDto;
import com.example.classOneProject.dto.Responce;

public interface AuthService {
    Responce login(LoginDto loginDto);
}
