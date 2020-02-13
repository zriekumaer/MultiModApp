package com.ust.invoice.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.ListResponse;
import com.ust.common.response.SingleResponse;
import com.ust.invoice.service.InvoiceTypeService;
import com.ust.invoice.service.bo.InvoiceTypeBO;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceTypeController {
	@Autowired
    private InvoiceTypeService invoiceTypeService;

    @GetMapping(value = "/type")
    public SingleResponse<InvoiceTypeBO> getInvoiceType(@PathVariable("invoiceTypeId") Long invoiceTypeId) {
        return new SingleResponse<InvoiceTypeBO>(invoiceTypeService.getInvoiceType(invoiceTypeId));
    }

    @GetMapping(value = "/all")
    public ListResponse<List<InvoiceTypeBO>> getAllInvoiceTypes() {
        return new ListResponse<List<InvoiceTypeBO>>(invoiceTypeService.getAllInvoiceTypes());
    }

}