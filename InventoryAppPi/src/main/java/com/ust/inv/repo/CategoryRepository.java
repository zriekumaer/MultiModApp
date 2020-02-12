package com.ust.inv.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.inv.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {


}