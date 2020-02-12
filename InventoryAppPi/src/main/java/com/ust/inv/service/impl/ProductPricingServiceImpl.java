package com.ust.inv.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.inv.domain.ProductPricingDomain;
import com.ust.inv.entity.ProductPricing;
import com.ust.inv.service.ProductPricingService;

public class ProductPricingServiceImpl implements ProductPricingService {

	@Autowired
	private ProductPricingDomain productPricingDomain;

	public void insert(ProductPricing productPricing) {
		productPricingDomain.insert(productPricing);
	}

	public Optional<ProductPricing> findById(int id) {
		return productPricingDomain.findById(id);
	}

	public Iterable<ProductPricing> findAll() {
		return productPricingDomain.findAll();
	}

	public void updateProductPricing(ProductPricing productPricing) {
		productPricingDomain.updateProductPricing(productPricing);
	}

	public void deleteProductPricing(ProductPricing productPricing) {
		productPricingDomain.deleteProductPricing(productPricing);
	}

}