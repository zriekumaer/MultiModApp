package com.ust.inv.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.entity.Pricing;
import com.ust.inv.repo.PricingRepository;

public class PricingDomainImpl {

    @Autowired
    private PricingRepository pricingRepository;

    public Iterable<Pricing> getAllStock() {
        return pricingRepository.findAll();
    }

    public void insert(Pricing pricing) {
        pricingRepository.save(pricing);
    }


    public Iterable<Pricing> findAll() {
        return pricingRepository.findAll();
    }

    public Optional<Pricing> find(int id) {
        return pricingRepository.findById(id);
    }

    public void updatePricing(Pricing pricing) {
        pricingRepository.save(pricing);
    }

    public void deletePricing(Pricing pricing) {
        pricingRepository.delete(pricing);
    }
}