package com.ust.inv.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.CategoryDomain;
import com.ust.inv.entity.Category;
import com.ust.inv.repo.CategoryRepository;

public class CategoryDomainImpl implements CategoryDomain{

    @Autowired
    private CategoryRepository categoryRepository;

    public void insert(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
}