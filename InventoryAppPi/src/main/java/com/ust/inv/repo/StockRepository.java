package com.ust.inv.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.inv.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,Integer> {
}