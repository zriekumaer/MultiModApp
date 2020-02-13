package com.ust.invoice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.invoice.entity.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}