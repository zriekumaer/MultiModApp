package com.ust.inv.domain;

import java.util.Optional;

import com.ust.inv.entity.Category;

public interface CategoryDomain {

    public void insert(Category category);

    public Optional<Category> findById(int id);

    public Iterable<Category> findAll();

    public void updateCategory(Category category);

    public void deleteCategory(Category category);
}