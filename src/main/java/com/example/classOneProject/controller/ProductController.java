package com.example.classOneProject.controller;

import com.example.classOneProject.annotation.ApiController;
import com.example.classOneProject.annotation.ValidateData;
import com.example.classOneProject.dto.ProductDto;
import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.service.ProductService;
import com.example.classOneProject.utill.ResponceBuilder;
import com.example.classOneProject.utill.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.ProductManagement.ROOT)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(UrlConstraint.ProductManagement.CREATE)
    @ValidateData
    public Responce create(@Valid @RequestBody ProductDto productDto, BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponceBuilder.getFailureResponce(result, "Bean Binding error");
//        }
        return productService.save(productDto);
    }

    @PutMapping(UrlConstraint.ProductManagement.UPDATE)
    @ValidateData
    public Responce update(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto, BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponceBuilder.getFailureResponce(result, "Bean Binding error");
//        }
        return productService.update(id, productDto);
    }

    @DeleteMapping(UrlConstraint.ProductManagement.DELETE)
    public Responce delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @GetMapping(UrlConstraint.ProductManagement.GET)
    public Responce get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @GetMapping(UrlConstraint.ProductManagement.GET_ALL)
    public Responce getAll() {
        return productService.getAll();
    }
}
