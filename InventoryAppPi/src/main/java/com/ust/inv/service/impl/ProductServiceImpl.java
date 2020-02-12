package com.ust.inv.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.ProductDomain;
import com.ust.inv.entity.Product;

public class ProductServiceImpl {

    @Autowired
    public ProductDomain productDomain;

    public void insert(Product product) {
    	productDomain.insert(product);
    }

    public Optional<Product> find(int id) {
        return productDomain.find(id);
    }

    public Iterable<Product> findAll() {
        return productDomain.findAll();
    }

    public void updateProduct(Product product) {
    	productDomain.updateProduct(product);
    }

    public void deleteProduct(Product product) {
    	productDomain.deleteProduct(product);
    }
}