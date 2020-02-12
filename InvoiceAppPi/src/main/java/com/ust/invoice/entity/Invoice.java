package com.ust.invoice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ust.common.entity.CommonEntity;

public class Invoice extends CommonEntity {

	@Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;
    @Column(name = "inv_create_date", nullable = false)
    private Date invCreateDate;
    @Column(name = "sale_date", nullable = false)
    private Date saleDate;
    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;
    @Column(name = "net_value", nullable = false)
    private Double netAmount;
    @Column(name = "gross_value", nullable = false)
    private Double grossAmount;
    @Column(name = "vat_value", nullable = false)
    private Double vatAmount;
//    private PaymentType paymentType;
//    private InvoiceType invoiceVersion;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;
//    private Set<InvoicePosition> invoicePositions;
//    private Set<InvoiceVat> invoiceVats;
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getInvCreateDate() {
		return invCreateDate;
	}
	public void setInvCreateDate(Date invCreateDate) {
		this.invCreateDate = invCreateDate;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	public Double getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}
	public Double getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}