package com.ust.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name = "vat_type")
public class VatType extends CommonEntity {

	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "value", nullable = false)
    private Double value;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}