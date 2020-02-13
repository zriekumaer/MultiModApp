package com.ust.invoice.service;

import java.util.List;

import com.ust.invoice.service.bo.InvoiceTypeBO;

public interface InvoiceTypeService {

    public InvoiceTypeBO getInvoiceType(Long invoiceTypeId);

    public List<InvoiceTypeBO> getAllInvoiceTypes();
}