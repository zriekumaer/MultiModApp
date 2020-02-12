package com.ust.inv.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.StockDomain;
import com.ust.inv.entity.Stock;
import com.ust.inv.repo.StockRepository;

public class StockDomainImpl implements StockDomain{
	
    @Autowired
    private StockRepository stockRepository;

    public void insert(Stock stock) {
        stockRepository.save(stock);
    }

    public Optional<Stock> findById(int id) {
        return stockRepository.findById(id);
    }

    public Iterable<Stock> findAll() {
        return stockRepository.findAll();
    }

    public void updateStock(Stock stock) {
        stockRepository.save(stock);
    }

    public void deleteStock(Stock stock) {
        stockRepository.delete(stock);
    }
}