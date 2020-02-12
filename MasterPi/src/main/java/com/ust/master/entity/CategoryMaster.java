package com.ust.master.entity;

import com.ust.common.entity.CommonEntity;

public class CategoryMaster extends CommonEntity {
	
	private String categoryCode;
	
	private String name;
	
	private String type;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
