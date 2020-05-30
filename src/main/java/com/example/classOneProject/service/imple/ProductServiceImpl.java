package com.example.classOneProject.service.imple;

import com.example.classOneProject.dto.ProductDto;
import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.model.Product;
import com.example.classOneProject.repository.ProductRepositoy;
import com.example.classOneProject.service.ProductService;
import com.example.classOneProject.utill.ResponceBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepositoy productRepositoy;
    private final ModelMapper modelMapper;
    private final String root = "prioduct";

    public ProductServiceImpl(ProductRepositoy productRepositoy, ModelMapper modelMapper) {
        this.productRepositoy = productRepositoy;
        this.modelMapper = modelMapper;
    }

    @Override
    public Responce save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);//ekta source ekta destination
        product = productRepositoy.save(product);
        if (product != null) {
            return ResponceBuilder.getSuccessResponce(HttpStatus.CREATED, root + "Created Successfuly", null);
        }
        return ResponceBuilder.getFailureResponce(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurs");
    }

    @Override
    public Responce update(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public Responce get(Long id) {
        return null;
    }

    @Override
    public Responce delete(Long id) {
        return null;
    }

    @Override
    public Responce getAll() {
        return null;
    }
}
