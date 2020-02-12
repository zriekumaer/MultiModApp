package com.ust.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name = "invoice_type")
public class InvoiceType extends CommonEntity {

	@Column(name = "name", nullable = false)
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}