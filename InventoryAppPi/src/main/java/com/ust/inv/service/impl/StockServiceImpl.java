package com.ust.inv.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.StockDomain;
import com.ust.inv.entity.Stock;
import com.ust.inv.service.StockService;

public class StockServiceImpl implements StockService{
    @Autowired
    private StockDomain stockDomain;

    public void insert(Stock stock) {
    	stockDomain.insert(stock);
    }

    public Optional<Stock> findById(int id) {
        return stockDomain.findById(id);
    }

    public Iterable<Stock> findAll() {
        return stockDomain.findAll();
    }

    public void updateStock(Stock stock) {
    	stockDomain.updateStock(stock);
    }

    public void deleteStock(Stock stock) {
    	stockDomain.deleteStock(stock);
    }
}