package com.ust.invoice.service.bo;


import com.ust.common.bo.CommonBO;

public class InvoiceTypeBO extends CommonBO {

    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}