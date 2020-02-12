package com.ust.inv.service;

import java.util.Optional;

import com.ust.inv.entity.Product;

public interface ProductService {

	public void insert(Product product);

    public Optional<Product> find(int id);

    public Iterable<Product> findAll();

    public void updateProduct(Product product);

    public void deleteProduct(Product product);
}