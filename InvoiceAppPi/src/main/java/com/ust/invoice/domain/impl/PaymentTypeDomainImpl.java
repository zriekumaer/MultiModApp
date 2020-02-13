package com.ust.invoice.domain.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.ust.invoice.entity.PaymentType;
import com.ust.invoice.repo.PaymentTypeRepository;
import com.ust.invoice.service.bo.PaymentTypeBO;

public class PaymentTypeDomainImpl {

	@Autowired
    private PaymentTypeRepository paymentTypeRepository;
    
    private ModelMapper modelMapper = new ModelMapper();

    public PaymentTypeBO getPaymentType(Long paymentTypeId) {
        PaymentType paymentType = paymentTypeRepository.findById(paymentTypeId)
                .orElseThrow( () -> new ResourceNotFoundException("PaymentType not exist id: " + paymentTypeId));
        return modelMapper.map(paymentType, PaymentTypeBO.class);
    }

    public List<PaymentTypeBO> getAllPaymentTypes() {
        return paymentTypeRepository.findAll().stream()
                .map(paymentType -> modelMapper.map(paymentType, PaymentTypeBO.class)).collect(Collectors.toList());
    }

}