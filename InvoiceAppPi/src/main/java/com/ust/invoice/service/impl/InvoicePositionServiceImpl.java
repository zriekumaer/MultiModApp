package com.ust.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.domain.InvoicePositionDomain;
import com.ust.invoice.service.InvoicePositionService;
import com.ust.invoice.service.bo.InvoicePositionBO;

@Service
public class InvoicePositionServiceImpl implements InvoicePositionService {
	
	@Autowired
	private InvoicePositionDomain invoicePositionDomain;

	@Override
	public List<InvoicePositionBO> getAllInvoicePositionsByInvoiceId(Long invoiceId) {
		return invoicePositionDomain.getAllInvoicePositionsByInvoiceId(invoiceId);
	}

	@Override
	public ObjectReference createInvoicePosition(InvoicePositionBO invoicePositionDTO) {
		return invoicePositionDomain.createInvoicePosition(invoicePositionDTO);
	}

}