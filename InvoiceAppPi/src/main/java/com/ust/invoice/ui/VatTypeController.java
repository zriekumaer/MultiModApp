package com.ust.invoice.ui;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.ListResponse;
import com.ust.common.response.SingleResponse;
import com.ust.invoice.service.VatTypeService;
import com.ust.invoice.service.bo.VatTypeBO;


@RestController
@RequestMapping(value = "/vat")
public class VatTypeController {
	@Autowired
    private VatTypeService vatTypeService;

    @GetMapping
    public SingleResponse<VatTypeBO> getVatType(@PathVariable("vatTypeId") Long vatTypeId) {
        return new SingleResponse<VatTypeBO>(vatTypeService.getVatType(vatTypeId));
    }

    @GetMapping(value = "/all")
    public ListResponse<List<VatTypeBO>> getAllInvoiceTypes() {
        return new ListResponse<List<VatTypeBO>>(vatTypeService.getAllPaymentTypes());
    }
}