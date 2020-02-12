package com.ust.inv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="stock")
//@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock extends CommonEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name="stock_date")
	private Date stockDate;

	@Column(name="quantity")
	private int quantity;

	@Column(name="product_id")
	private Integer productId;

	@Column(name="supplier_id")
	private Integer supplierId;

	@Column(name="category_id")
	private Category categoryId;

	public Stock() {
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}