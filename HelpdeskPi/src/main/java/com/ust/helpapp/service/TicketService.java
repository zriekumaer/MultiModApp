package com.ust.helpapp.service;

import org.springframework.data.domain.Page;

import com.ust.helpapp.entity.ChangeStatus;
import com.ust.helpapp.entity.Ticket;

public interface TicketService {
	
	public Ticket createOrUpdate(Ticket ticket);
	
	public Ticket findById(Integer id);
	
	public void delete(Integer id);
	
	public Page<Ticket> listTicket(int page, int count);
	
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	
	Iterable<ChangeStatus> listChangeStatus(String ticketId);
	
	Page<Ticket> findByCurrentUser(int page, int count, String userId);
	
	Page<Ticket> findByParameters(int page, int count, String title, String status,String priority);
	
	Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,String priority, String userId);
	
	Page<Ticket> findByNumber(int page, int count, Integer number);
	
	Iterable<Ticket> findAll();
	
	Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status, String priority, String assignedUser);
}