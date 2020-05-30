package com.example.classOneProject.SprinController;

import com.example.classOneProject.annotation.ApiController;
import com.example.classOneProject.dto.ProductDto;
import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.service.ProductService;
import com.example.classOneProject.utill.ResponceBuilder;
import com.example.classOneProject.utill.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.ProductManagement.ROOT)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(UrlConstraint.ProductManagement.CREATE)
    public Responce create(@Valid @RequestBody ProductDto productDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponceBuilder.getFailureResponce(result, "Bean Binding error");
        }
        return productService.save(productDto);
    }
}
