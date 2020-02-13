package com.ust.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.invoice.domain.InvoiceTypeDomain;
import com.ust.invoice.service.InvoiceTypeService;
import com.ust.invoice.service.bo.InvoiceTypeBO;

@Service
public class InvoiceTypeServiceImpl implements InvoiceTypeService {

	@Autowired
	private InvoiceTypeDomain invoiceTypeDomain;
	
	@Override
	public InvoiceTypeBO getInvoiceType(Long invoiceTypeId) {
		return invoiceTypeDomain.getInvoiceType(invoiceTypeId);
	}

	@Override
	public List<InvoiceTypeBO> getAllInvoiceTypes() {
		return invoiceTypeDomain.getAllInvoiceTypes();
	}

   
}