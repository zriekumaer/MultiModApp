package com.ust.inv.domain;

import java.util.Optional;

import com.ust.inv.entity.Stock;

public interface StockDomain {

    public void insert(Stock stock);

    public Optional<Stock> findById(int id);

    public Iterable<Stock> findAll();

    public void updateStock(Stock stock);

    public void deleteStock(Stock stock);

}