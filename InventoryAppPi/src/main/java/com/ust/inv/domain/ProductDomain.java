package com.ust.inv.domain;

import java.util.Optional;

import com.ust.inv.entity.Product;

public interface ProductDomain {

    public void insert(Product product) ;

    public Optional<Product> find(int id);

    public Iterable<Product> findAll();

    public void updateProduct(Product product);

    public void deleteProduct(Product product);
}