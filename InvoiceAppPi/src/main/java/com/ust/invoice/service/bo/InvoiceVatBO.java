package com.ust.invoice.service.bo;


import com.ust.common.bo.CommonBO;

public class InvoiceVatBO extends CommonBO {

    private VatTypeBO vatType;
	
    private Double netValue;
	
    private Double vatValue;
	
    private Double grossValue;
	
    private InvoiceBO invoice;

    public VatTypeBO getVatType() {
        return vatType;
    }

    public void setVatType(VatTypeBO vatType) {
        this.vatType = vatType;
    }

    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Double getVatValue() {
        return vatValue;
    }

    public void setVatValue(Double vatValue) {
        this.vatValue = vatValue;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(Double grossValue) {
        this.grossValue = grossValue;
    }

    public InvoiceBO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceBO invoice) {
        this.invoice = invoice;
    }
}