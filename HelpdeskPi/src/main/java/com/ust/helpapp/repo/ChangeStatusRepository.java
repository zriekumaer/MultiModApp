package com.ust.helpapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ust.helpapp.entity.ChangeStatus;

public interface ChangeStatusRepository extends JpaRepository<ChangeStatus, Integer> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

	
}