package com.ust.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.invoice.domain.PaymentTypeDomain;
import com.ust.invoice.service.PaymentTypeService;
import com.ust.invoice.service.bo.PaymentTypeBO;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

	@Autowired
	private PaymentTypeDomain paymentTypeDomain;
	
	@Override
	public PaymentTypeBO getPaymentType(Long paymentTypeId) {
		return paymentTypeDomain.getPaymentType(paymentTypeId);
	}

	@Override
	public List<PaymentTypeBO> getAllPaymentTypes() {
		return paymentTypeDomain.getAllPaymentTypes();
	}


}