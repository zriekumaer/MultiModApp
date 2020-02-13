package com.ust.invoice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.invoice.entity.InvoiceVat;

public interface InvoiceVatRepository extends JpaRepository<InvoiceVat, Long> {
}