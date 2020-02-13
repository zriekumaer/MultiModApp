package com.ust.invoice.service;

import java.util.List;

import com.ust.invoice.service.bo.VatTypeBO;

public interface VatTypeService {

    public VatTypeBO getVatType(Long vatTypeId);

    public List<VatTypeBO> getAllPaymentTypes();
}