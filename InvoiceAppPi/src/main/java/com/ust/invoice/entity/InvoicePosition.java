package com.ust.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name = "invoice_position")
public class InvoicePosition extends CommonEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="invoice_id", referencedColumnName = "id", nullable = false)
    private Invoice invoice;
	
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "quantity", nullable = false)
    private Double quantity;
    
    @Column(name = "net_price", nullable = false)
    private Double netPrice;
    
    @Column(name = "net_value", nullable = false)
    private Double netValue;
    
    @Column(name = "gross_value", nullable = false)
    private Double grossValue;

    @ManyToOne
    @JoinColumn(name = "vat_type", referencedColumnName = "id", nullable = false)
    private VatType vatType;
    
    @Column(name = "vat_value", nullable = false)
    private Double vatValue;

    
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
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

    public VatType getVatType() {
        return vatType;
    }

    public void setVatType(VatType vatType) {
        this.vatType = vatType;
    }

    public Double getVatValue() {
        return vatValue;
    }

    public void setVatValue(Double vatValue) {
        this.vatValue = vatValue;
    }
}