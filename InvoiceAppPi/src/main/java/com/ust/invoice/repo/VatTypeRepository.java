package com.ust.invoice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.invoice.entity.VatType;

public interface VatTypeRepository extends JpaRepository<VatType, Long> {
	
}