package com.ust.invoice.domain.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.entity.InvoicePosition;
import com.ust.invoice.repo.InvoicePositionRepository;
import com.ust.invoice.service.bo.InvoicePositionBO;

public class InvoicePositionDomainImpl {

	@Autowired
    private InvoicePositionRepository invoicePositionRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

    public List<InvoicePositionBO> getAllInvoicePositionsByInvoiceId(Long invoiceId) {
        return invoicePositionRepository.findAllByInvoiceId(invoiceId).stream()
                .map(invoicePosition -> modelMapper.map(invoicePosition, InvoicePositionBO.class)).collect(Collectors.toList());
    }

    public ObjectReference createInvoicePosition(InvoicePositionBO invoicePositionBO) {
        InvoicePosition invoicePosition = modelMapper.map(invoicePositionBO, InvoicePosition.class);
        invoicePositionRepository.save(invoicePosition);
        return new ObjectReference(invoicePosition.getId().longValue());
    }

}