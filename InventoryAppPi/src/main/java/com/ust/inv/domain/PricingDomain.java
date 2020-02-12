package com.ust.inv.domain;

import java.util.Optional;

import com.ust.inv.entity.Pricing;

public interface PricingDomain {

    public Iterable<Pricing> getAllStock();
    
    public void insert(Pricing pricing);

    public Iterable<Pricing> findAll();

    public Optional<Pricing> find(int id);

    public void updatePricing(Pricing pricing);

    public void deletePricing(Pricing pricing);


}