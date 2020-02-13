package com.ust.invoice.service;

import java.util.List;

import com.ust.invoice.service.bo.PaymentTypeBO;

public interface PaymentTypeService {
    
    public PaymentTypeBO getPaymentType(Long paymentTypeId);

    public List<PaymentTypeBO> getAllPaymentTypes();

}