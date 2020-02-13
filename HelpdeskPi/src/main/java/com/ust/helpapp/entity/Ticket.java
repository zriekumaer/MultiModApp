package com.ust.helpapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="help_ticket_info")
public class Ticket extends CommonEntity {

	@Column(name="title")
	private String title;
	
	@Column(name="email")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="number")
	private Integer number;
	
	@Column(name="status")
	private String status;
	
	@Column(name="priority")
	private String priority;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
}