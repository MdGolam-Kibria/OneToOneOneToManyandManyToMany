package com.example.classOneProject.service.imple;

import com.example.classOneProject.dto.ProductDto;
import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.model.Product;
import com.example.classOneProject.repository.ProductRepositoy;
import com.example.classOneProject.service.ProductService;
import com.example.classOneProject.utill.ResponceBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepositoy productRepositoy;
    private final ModelMapper modelMapper;
    private final String root = "product";

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
        Product product = productRepositoy.findByIdAndIsActiveTrue(id);
        if (product != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());//for ignore null value.
            modelMapper.map(productDto, product);
            product = productRepositoy.save(product);
            if (product != null) {
                return ResponceBuilder.getSuccessResponce(HttpStatus.OK, root + " Updated successfuly", null);
            }
            return ResponceBuilder.getFailureResponce(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurs");
        }
        return ResponceBuilder.getFailureResponce(HttpStatus.NOT_FOUND, root + " Not Found");
    }

    @Override
    public Responce get(Long id) {
        Product product = productRepositoy.findByIdAndIsActiveTrue(id);
        if (product != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            if (product != null) {
                return ResponceBuilder.getSuccessResponce(HttpStatus.OK, root + " retrieved Successfully", productDto);
            }
            return ResponceBuilder.getFailureResponce(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponceBuilder.getFailureResponce(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Responce delete(Long id) {
        Product product = productRepositoy.findByIdAndIsActiveTrue(id);
        if (product != null) {
            product.setIsActive(false);
            product = productRepositoy.save(product);
            if (product != null) {
                return ResponceBuilder.getSuccessResponce(HttpStatus.OK, root + " deleted Successfully", null);
            }
            return ResponceBuilder.getFailureResponce(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponceBuilder.getFailureResponce(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Responce getAll() {
        List<Product>products = productRepositoy.findAllByIsActiveTrue();
        List<ProductDto> productDtos = this.getProducts(products);
        return ResponceBuilder.getSuccessResponce(HttpStatus.OK, root + " retrieved Successfully",productDtos);
    }

    private List<ProductDto> getProducts(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
           ProductDto productDto =  modelMapper.map(product,ProductDto.class);
            productDtos.add(productDto);
        });
        return productDtos;
    }
}
