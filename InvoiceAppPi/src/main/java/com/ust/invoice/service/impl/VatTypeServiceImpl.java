package com.ust.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.invoice.domain.VatTypeDomain;
import com.ust.invoice.service.VatTypeService;
import com.ust.invoice.service.bo.VatTypeBO;

@Service
public class VatTypeServiceImpl implements VatTypeService {
	
	@Autowired
	private VatTypeDomain vatTypeDomain;

	@Override
	public VatTypeBO getVatType(Long vatTypeId) {
		return vatTypeDomain.getVatType(vatTypeId);
	}

	@Override
	public List<VatTypeBO> getAllPaymentTypes() {
		return vatTypeDomain.getAllPaymentTypes();
	}
 
}