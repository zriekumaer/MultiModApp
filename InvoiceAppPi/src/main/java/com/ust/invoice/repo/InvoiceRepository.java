package com.ust.invoice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.invoice.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	List<Invoice> findAllByUserIdAndActive(Long userId, boolean active);

	Optional<Invoice> findByIdAndActive(Long userId, boolean active);

	List<Invoice> findAllByActive(boolean active);

	List<Invoice> findFirst5ByUserIdAndActiveOrderByCreateDateDesc(Long userId, boolean active);
}