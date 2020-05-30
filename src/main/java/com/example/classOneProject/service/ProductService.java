package com.example.classOneProject.service;

import com.example.classOneProject.dto.ProductDto;
import com.example.classOneProject.dto.Responce;

public interface ProductService {
    Responce save(ProductDto productDto);
    Responce update(Long id,ProductDto productDto);
    Responce get(Long id);
    Responce delete(Long id);
    Responce getAll();
}
