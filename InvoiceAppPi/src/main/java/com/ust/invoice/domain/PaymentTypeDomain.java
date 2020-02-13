package com.ust.invoice.domain;

import java.util.List;

import com.ust.invoice.service.bo.PaymentTypeBO;

public interface PaymentTypeDomain {
    
    public PaymentTypeBO getPaymentType(Long paymentTypeId);

    public List<PaymentTypeBO> getAllPaymentTypes();

}