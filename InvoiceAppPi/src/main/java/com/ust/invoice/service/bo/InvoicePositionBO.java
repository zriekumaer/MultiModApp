package com.ust.invoice.service.bo;

import com.ust.common.bo.CommonBO;

public class InvoicePositionBO extends CommonBO {

    private InvoiceBO invoice;
	
    private String name;
    
    private String unit;
    
    private Double quantity;
    
    private Double netPrice;

    private Double netValue;
    
    private Double grossValue;

    private VatTypeBO vatType;
    
    private Double vatValue;
    
    public InvoiceBO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceBO invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(Double grossValue) {
        this.grossValue = grossValue;
    }

    public VatTypeBO getVatType() {
        return vatType;
    }

    public void setVatType(VatTypeBO vatType) {
        this.vatType = vatType;
    }

    public Double getVatValue() {
        return vatValue;
    }

    public void setVatValue(Double vatValue) {
        this.vatValue = vatValue;
    }
}