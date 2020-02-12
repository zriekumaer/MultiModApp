package com.ust.inv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="pricing")
public class Pricing extends CommonEntity {
	
	@Column(name="price_disc_pct")
	private Double pricingDiscountPrecentage;

	@Column(name="price_name")
	private String pricingName;

	public Pricing() {
	}

	public Double getPricingDiscountPrecentage() {
		return pricingDiscountPrecentage;
	}

	public void setPricingDiscountPrecentage(Double pricingDiscountPrecentage) {
		this.pricingDiscountPrecentage = pricingDiscountPrecentage;
	}

	public String getPricingName() {
		return pricingName;
	}

	public void setPricingName(String pricingName) {
		this.pricingName = pricingName;
	}
}