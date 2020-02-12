package com.ust.inv.service;

import java.util.Optional;

import com.ust.inv.entity.Pricing;

public interface PricingService {

	public Iterable<Pricing> getAllStock();
    
    public void insert(Pricing pricing);

    public Iterable<Pricing> findAll();

    public Optional<Pricing> find(int id);

    public void updatePricing(Pricing pricing);

    public void deletePricing(Pricing pricing);
}