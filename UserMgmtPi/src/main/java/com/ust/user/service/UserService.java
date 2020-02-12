package com.ust.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ust.common.entity.UserEntity;
import com.ust.user.service.bo.UserBO;

import java.util.List;

public interface UserService {
	
    public UserBO findUserByEmail(String email);

    public void saveUser(UserBO user);

    public Boolean removeAll();

    public void removeById(Integer id);

    public UserBO findById(Integer id);

    public Page <UserBO> searchByTerm(String name, Pageable pageable);

    public Page<UserBO> listUsers(Pageable pageable);

    public List<UserBO> searchBy(String keyword, String criteria);
}
