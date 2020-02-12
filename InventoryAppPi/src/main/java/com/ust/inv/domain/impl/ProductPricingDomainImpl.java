package com.ust.inv.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.ProductPricingDomain;
import com.ust.inv.entity.ProductPricing;
import com.ust.inv.repo.ProductPricingRepository;

public class ProductPricingDomainImpl implements ProductPricingDomain {

	@Autowired
	private ProductPricingRepository productPricingRepository;

	public void insert(ProductPricing productPricing) {
		productPricingRepository.save(productPricing);
	}

	public Optional<ProductPricing> findById(int id) {
		return productPricingRepository.findById(id);
	}

	public Iterable<ProductPricing> findAll() {
		return productPricingRepository.findAll();
	}

	public void updateProductPricing(ProductPricing productPricing) {
		productPricingRepository.save(productPricing);
	}

	public void deleteProductPricing(ProductPricing productPricing) {
		productPricingRepository.delete(productPricing);
	}
}