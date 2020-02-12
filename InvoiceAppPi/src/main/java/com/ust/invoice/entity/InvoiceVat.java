package com.ust.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name = "invoice_vat")
public class InvoiceVat extends CommonEntity {

	@ManyToOne
    @JoinColumn(name = "vat_type", referencedColumnName = "id")
    private VatType vatType;
	
	@Column(name = "net_value", nullable = false)
    private Double netValue;
	
	@Column(name = "vat_value", nullable = false)
    private Double vatValue;
	
	@Column(name = "gross_value", nullable = false)
    private Double grossValue;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="invoice_id", referencedColumnName = "id", nullable = false)
    private Invoice invoice;

    public VatType getVatType() {
        return vatType;
    }

    public void setVatType(VatType vatType) {
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}