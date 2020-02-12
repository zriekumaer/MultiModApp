package com.ust.inv.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.inv.entity.Pricing;

@Repository
public interface PricingRepository extends CrudRepository<Pricing, Integer> {

}