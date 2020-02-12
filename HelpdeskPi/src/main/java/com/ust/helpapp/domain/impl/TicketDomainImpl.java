package com.ust.helpapp.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.ust.helpapp.domain.TicketDomain;
import com.ust.helpapp.entity.ChangeStatus;
import com.ust.helpapp.entity.Ticket;
import com.ust.helpapp.repo.TicketRepository;

@Repository
public class TicketDomainImpl implements TicketDomain {
	
	@Autowired
	private TicketRepository ticketRepository;

	public Ticket findById(Integer id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		return ticket.isPresent() ? ticket.get() : null;
	}
	
	public Ticket createOrUpdate(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	public Page<Ticket> listTicket(int page, int count) {
		return null;
	}

	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return null;
	}

	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return null;
	}

	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		return null;
	}

	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		return null;
	}

	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		return null;
	}

	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		return null;
	}

	public Iterable<Ticket> findAll() {
		return null;
	}

	public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status,
			String priority, String assignedUser) {
		return null;
	}
}
