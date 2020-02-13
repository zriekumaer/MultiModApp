package com.ust.invoice.service.bo;

import java.util.Date;


import com.ust.common.bo.CommonBO;

public class InvoiceBO extends CommonBO {

    private String invoiceNumber;
    private Date invCreateDate;
    private Date saleDate;
    private Date paymentDate;
    private Double netAmount;
    private Double grossAmount;
    private Double vatAmount;
//    private PaymentType paymentType;
//    private InvoiceType invoiceVersion;
    private ClientBO client;
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
	public ClientBO getClient() {
		return client;
	}
	public void setClient(ClientBO client) {
		this.client = client;
	}
}