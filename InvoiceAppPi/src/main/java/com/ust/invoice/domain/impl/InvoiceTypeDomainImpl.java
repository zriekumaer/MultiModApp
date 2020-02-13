package com.ust.invoice.domain.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.ust.invoice.entity.InvoiceType;
import com.ust.invoice.repo.InvoiceTypeRepository;
import com.ust.invoice.service.bo.InvoiceTypeBO;

public class InvoiceTypeDomainImpl {

	@Autowired
    private InvoiceTypeRepository invoiceTypeRepository;
	
	@Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public InvoiceTypeBO getInvoiceType(Long invoiceTypeId) {
        InvoiceType invoiceType = invoiceTypeRepository.findById(invoiceTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("InvoiceType not exist id: " + invoiceTypeId));
        return modelMapper.map(invoiceType, InvoiceTypeBO.class);
    }

    public List<InvoiceTypeBO> getAllInvoiceTypes() {
        return invoiceTypeRepository.findAll().stream()
                .map(invoiceType -> modelMapper.map(invoiceType, InvoiceTypeBO.class)).collect(Collectors.toList());
    }
}