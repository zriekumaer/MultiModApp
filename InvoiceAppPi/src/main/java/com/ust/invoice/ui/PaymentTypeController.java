package com.ust.invoice.ui;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.ListResponse;
import com.ust.common.response.SingleResponse;
import com.ust.invoice.service.PaymentTypeService;
import com.ust.invoice.service.bo.PaymentTypeBO;


@RestController
@RequestMapping(value = "/payment")
public class PaymentTypeController {
	
	@Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping
    public SingleResponse<PaymentTypeBO> getPaymentType(@PathVariable("paymentTypeId") Long paymentTypeId) {
        return new SingleResponse<PaymentTypeBO>(paymentTypeService.getPaymentType(paymentTypeId));
    }

    @GetMapping(value = "/all")
    public ListResponse<List<PaymentTypeBO>> getAllInvoiceTypes() {
        return new ListResponse<List<PaymentTypeBO>>(paymentTypeService.getAllPaymentTypes());
    }

}