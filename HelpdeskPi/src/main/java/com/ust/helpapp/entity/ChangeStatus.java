package com.ust.helpapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="change_status")
public class ChangeStatus extends CommonEntity {

	@Column(name="ticket")
	private Integer ticketId;
	
	@Column(name="status")
	private String status;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}