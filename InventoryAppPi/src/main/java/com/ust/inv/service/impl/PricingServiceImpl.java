package com.ust.inv.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ust.inv.domain.PricingDomain;
import com.ust.inv.entity.Pricing;

@Transactional
@Service
public class PricingServiceImpl {

    @Autowired
    private PricingDomain pricingDomain;

    public Iterable<Pricing> getAllStock() {
        return pricingDomain.findAll();
    }

    public void insert(Pricing pricing) {
    	pricingDomain.insert(pricing);
    }

    public Iterable<Pricing> findAll() {
        return pricingDomain.findAll();
    }

    public Optional<Pricing> find(int id) {
        return pricingDomain.find(id);
    }

    public void updatePricing(Pricing pricing) {
    	pricingDomain.updatePricing(pricing);
    }

    public void deletePricing(Pricing pricing) {
    	pricingDomain.deletePricing(pricing);
    }


}