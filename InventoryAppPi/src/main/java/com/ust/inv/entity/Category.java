package com.ust.inv.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="category")
//@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category extends CommonEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_name")
	private String categoryName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="category")
	private List<Stock> stocks;
	
	