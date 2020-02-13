package com.ust.invoice.domain;

import java.util.List;

import com.ust.invoice.service.bo.InvoiceTypeBO;

public interface InvoiceTypeDomain {

    public InvoiceTypeBO getInvoiceType(Long invoiceTypeId);

    public List<InvoiceTypeBO> getAllInvoiceTypes();
}