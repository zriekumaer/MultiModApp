package com.ust.inv.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="product")
public class Product extends CommonEntity {
	
	@Column(name="prod_buy_price")
	private double productbuyingPrice;

	@Column(name="is_prod_service")
	private byte productIsService;

	@Column(name="prod_name")
	private String productName;

	@Column(name="prod_sell-price")
	private double productsellingPrice;

	@Column(name="cat_id")
	private Integer categoryId;

	public double getProductbuyingPrice() {
		return productbuyingPrice;
	}

	public void setProductbuyingPrice(double productbuyingPrice) {
		this.productbuyingPrice = productbuyingPrice;
	}

	public byte getProductIsService() {
		return productIsService;
	}

	public void setProductIsService(byte productIsService) {
		this.productIsService = productIsService;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductsellingPrice() {
		return productsellingPrice;
	}

	public void setProductsellingPrice(double productsellingPrice) {
		this.productsellingPrice = productsellingPrice;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}