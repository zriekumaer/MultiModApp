package com.ust.inv.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.entity.Product;
import com.ust.inv.repo.ProductRepository;

public class ProductDomainImpl {

    @Autowired
    public ProductRepository productRepository;

    public void insert(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> find(int id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}