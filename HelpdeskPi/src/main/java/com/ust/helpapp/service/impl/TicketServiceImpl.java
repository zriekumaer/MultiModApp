package com.ust.helpapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ust.helpapp.domain.TicketDomain;
import com.ust.helpapp.entity.ChangeStatus;
import com.ust.helpapp.entity.Ticket;
import com.ust.helpapp.repo.ChangeStatusRepository;
import com.ust.helpapp.repo.TicketRepository;
import com.ust.helpapp.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDomain ticketDomain;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	public Ticket createOrUpdate(Ticket ticket) {
		return ticketDomain.createOrUpdate(ticket);
	}

	public Ticket findById(Integer id) {
		return ticketDomain.findById(id);
	}

	public void delete(Integer id) {
		ticketDomain.delete(id);
	}

	public Page<Ticket> listTicket(int page, int count) {
		return ticketDomain.listTicket(page, count);
	}

	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return ticketDomain.createChangeStatus(changeStatus);
	}

	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return ticketDomain.listChangeStatus(ticketId);
	}

	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		return ticketDomain.findByCurrentUser(page, count, userId);
	}

	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		return ticketDomain.findByParameters(page, count, title, status, priority);
	}

	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		return ticketDomain.findByParametersAndCurrentUser(page, count, title, status, priority, userId);
	}

	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		return ticketDomain.findByNumber(page, count, number);
	}

	public Iterable<Ticket> findAll() {
		return ticketDomain.findAll();
	}

	public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status,
			String priority, String assignedUser) {
		return ticketDomain.findByParametersAndAssignedUser(page, count, title, status, priority, assignedUser);
	}

	public Page<Ticket> findByCurrentUser(int page, int count, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}