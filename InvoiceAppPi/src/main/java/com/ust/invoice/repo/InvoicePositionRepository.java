package com.ust.invoice.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.invoice.entity.InvoicePosition;

import java.util.List;

public interface InvoicePositionRepository extends JpaRepository<InvoicePosition, Long> {
	
    List<InvoicePosition> findAllByInvoiceId(Long invoiceId);
}