package com.ust.invoice.service.bo;


import com.ust.common.bo.CommonBO;

public class VatTypeBO extends CommonBO {

    private String name;
	
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