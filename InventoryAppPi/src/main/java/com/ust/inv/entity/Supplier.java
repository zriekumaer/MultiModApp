package com.ust.inv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="supplier")
public class Supplier extends CommonEntity {
	
	@Column(name="supp_code")
	private String supplierCode;
	
	@Column(name="supp_name")
	private String supplierName;
	
	@Column(name="is_supp_comp")
	private String isSupplierCompany;


	public Supplier() {
	}


	public String getSupplierCode() {
		return supplierCode;
	}


	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getIsSupplierCompany() {
		return isSupplierCompany;
	}


	public void setIsSupplierCompany(String isSupplierCompany) {
		this.isSupplierCompany = isSupplierCompany;
	}

}