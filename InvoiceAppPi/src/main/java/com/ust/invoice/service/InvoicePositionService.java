package com.ust.invoice.service;

import java.util.List;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.service.bo.InvoicePositionBO;

public interface InvoicePositionService {

    public List<InvoicePositionBO> getAllInvoicePositionsByInvoiceId(Long invoiceId);

    public ObjectReference createInvoicePosition(InvoicePositionBO invoicePositionDTO);

}