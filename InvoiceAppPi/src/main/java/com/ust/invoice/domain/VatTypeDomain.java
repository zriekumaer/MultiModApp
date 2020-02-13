package com.ust.invoice.domain;

import java.util.List;

import com.ust.invoice.service.bo.VatTypeBO;

public interface VatTypeDomain {

    public VatTypeBO getVatType(Long vatTypeId);

    public List<VatTypeBO> getAllPaymentTypes();
}