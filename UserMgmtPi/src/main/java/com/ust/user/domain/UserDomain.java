package com.ust.user.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ust.common.entity.UserEntity;
import com.ust.user.service.bo.UserBO;

public interface UserDomain {
	public Page<UserEntity> listUsers(Pageable pageable);

	public UserEntity findUserByEmail(String email);

	public UserBO saveUser(UserBO user);

	public Page<UserBO> searchByTerm(String name, Pageable pageable);

	public Boolean removeAll();

	public void removeById(Integer id);

	public UserBO findById(Integer id);

	public List<UserBO> searchBy(String keyword, String criteria);

	public Page<UserBO> findAll(int page, int count);

	public void delete(String id);

}
