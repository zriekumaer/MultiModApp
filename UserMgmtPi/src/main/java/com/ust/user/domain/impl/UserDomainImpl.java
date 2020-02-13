package com.ust.user.domain.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.ust.common.entity.UserEntity;
import com.ust.user.domain.UserDomain;
import com.ust.user.repo.UserRepository;
import com.ust.user.service.bo.UserBO;

public class UserDomainImpl implements UserDomain {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<UserEntity> listUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public UserEntity findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public UserBO saveUser(UserBO user) {
		UserEntity entity = new UserEntity();
		UserBO userBO = new UserBO();
		// Convert Bo to Entity
		if (entity.getId() == null) {
			entity.setPassword(entity.getPassword());
			entity.setActive(Boolean.TRUE);
		}
		userRepository.save(entity);
		//convert entity to Bo
		return userBO;
	}

	public Page<UserBO> searchByTerm(String name, Pageable pageable) {
		Page<UserEntity> page = userRepository.searchByTerm(name, pageable);
		// Convert entity to bo
		List<UserBO> content = new ArrayList<UserBO>();
		Page<UserBO> returnPage = new PageImpl<UserBO>(content);
		return returnPage;
	}

	public Boolean removeAll() {
		userRepository.deleteAll();
		return Boolean.TRUE;
	}

	public void removeById(Integer id) {
		userRepository.deleteById(id.longValue());
	}
	
	public UserBO findById(Integer id) {
        UserEntity entity = userRepository.findById(id.longValue()).get();
        UserBO bo = new UserBO();
        //Convert
        return bo;
    }
	
	public List<UserBO> searchBy(String keyword, String criteria) {
		List<UserBO> list = new ArrayList<UserBO>();
		List<UserEntity> entities = null;
        if ("firstName".equals(criteria)) {
        	entities = userRepository.findByFirstNameIgnoreCaseContaining(keyword);
        } else if ("lastName".equals(criteria)) {
        	entities = userRepository.findByLastNameIgnoreCaseContaining(keyword);
        } else if ("email".equals(criteria)) {
        	entities = userRepository.findByEmailIgnoreCaseContaining(keyword);
        }
        //Convert entities to list;
        return list;
    }

	@Override
	public Page<UserBO> findAll(int page, int count) {
		return null;
	}

	@Override
	public void delete(String id) {
		
	}
	
	

}
