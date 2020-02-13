package com.ust.invoice.domain;

import java.util.List;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.service.bo.InvoicePositionBO;

public interface InvoicePositionDomain {

    public List<InvoicePositionBO> getAllInvoicePositionsByInvoiceId(Long invoiceId);

    public ObjectReference createInvoicePosition(InvoicePositionBO invoicePositionDTO);

}