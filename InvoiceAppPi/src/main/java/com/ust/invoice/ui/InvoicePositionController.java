package com.ust.invoice.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.ListResponse;
import com.ust.common.response.ObjectReference;
import com.ust.common.response.SingleResponse;
import com.ust.invoice.service.InvoicePositionService;
import com.ust.invoice.service.bo.InvoicePositionBO;

@RestController
@RequestMapping(value = "/invoice/position")
public class InvoicePositionController {

	@Autowired
    private InvoicePositionService invoicePositionService;

    @PostMapping
    public SingleResponse<ObjectReference> createInvoicePosition(@RequestBody InvoicePositionBO invoicePositionDTO){
        return new SingleResponse<ObjectReference>(invoicePositionService.createInvoicePosition(invoicePositionDTO));
    }

    @GetMapping
    public ListResponse<List<InvoicePositionBO>> getAllInvoicePositionsByInvoiceId(@PathVariable("invoiceId") Long invoiceId) {
        return new ListResponse<List<InvoicePositionBO>>(invoicePositionService.getAllInvoicePositionsByInvoiceId(invoiceId));
    }

}