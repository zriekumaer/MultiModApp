package com.ust.invoice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.invoice.entity.InvoiceType;

public interface InvoiceTypeRepository extends JpaRepository<InvoiceType, Long> {
}