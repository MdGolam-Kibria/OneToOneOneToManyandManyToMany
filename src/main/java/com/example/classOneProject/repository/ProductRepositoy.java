package com.example.classOneProject.repository;

import com.example.classOneProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoy extends JpaRepository<Product,Long> {
    Product findByIdAndIsActiveTrue(Long id);
}
