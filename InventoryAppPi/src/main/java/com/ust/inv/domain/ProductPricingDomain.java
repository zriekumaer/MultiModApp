package com.ust.inv.domain;

import java.util.Optional;

import com.ust.inv.entity.ProductPricing;

public interface ProductPricingDomain {

	public void insert(ProductPricing productPricing);

	public Optional<ProductPricing> findById(int id);

	public Iterable<ProductPricing> findAll();

	public void updateProductPricing(ProductPricing productPricing);

	public void deleteProductPricing(ProductPricing productPricing);

}