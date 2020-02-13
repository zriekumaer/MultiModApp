package com.ust.invoice.domain.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.ust.invoice.entity.VatType;
import com.ust.invoice.repo.VatTypeRepository;
import com.ust.invoice.service.bo.VatTypeBO;

public class VatTypeDomainImpl {

	@Autowired
	private VatTypeRepository vatTypeRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public VatTypeBO getVatType(Long vatTypeId) {
		VatType vatType = vatTypeRepository.findById(vatTypeId)
				.orElseThrow(() -> new ResourceNotFoundException("VatType not exist id: " + vatTypeId));
		return modelMapper.map(vatType, VatTypeBO.class);
	}

	public List<VatTypeBO> getAllPaymentTypes() {
		return vatTypeRepository.findAll().stream().map(vatType -> modelMapper.map(vatType, VatTypeBO.class))
				.collect(Collectors.toList());
	}
}