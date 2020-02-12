package com.ust.inv.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.CategoryDomain;
import com.ust.inv.entity.Category;
import com.ust.inv.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDomain categoryDomain;

    public void insert(Category category) {
    	categoryDomain.insert(category);
    }

    public Optional<Category> findById(int id) {
        return categoryDomain.findById(id);
    }

    public Iterable<Category> findAll() {
        return categoryDomain.findAll();
    }

    public void updateCategory(Category category) {
    	categoryDomain.updateCategory(category);
    }

    public void deleteCategory(Category category) {
    	categoryDomain.deleteCategory(category);
    }
}