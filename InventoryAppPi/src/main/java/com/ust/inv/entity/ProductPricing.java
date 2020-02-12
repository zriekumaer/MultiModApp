package com.ust.inv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="product_pricing")

public class ProductPricing extends CommonEntity {

	@Column(name="pricing_id")
	private Integer pricingId;

	@Column(name="pricing_id")
	private Integer productId;

	public ProductPricing() {
	}

	public Integer getPricingId() {
		return pricingId;
	}

	public void setPricingId(Integer pricingId) {
		this.pricingId = pricingId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}