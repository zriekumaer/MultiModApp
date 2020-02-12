package com.ust.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name="UserCategory")
public class UserCatergory extends CommonEntity {
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="category_id")
	private String categoryId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
