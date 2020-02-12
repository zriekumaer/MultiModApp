package com.ust.helpapp.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.helpapp.entity.Ticket;

public interface TicketRepository extends JpaRepository <Ticket, Integer> {
	
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages,String userid);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
			String title, String status, String Priority, Pageable pages);

	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, String status, String Priority, Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
			String title, String status, String Priority, Pageable pages);

	Page<Ticket> findByNumber(Integer number, Pageable pages);
}