package com.ust.user.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ust.common.entity.UserEntity;
import com.ust.user.domain.UserDomain;
import com.ust.user.repo.UserRepository;
import com.ust.user.service.UserService;
import com.ust.user.service.bo.UserBO;


@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDomain userDomain;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserBO findUserByEmail(String email) {
    	UserBO userBO = new UserBO();
    	//Convert return type of 
    	// userDomain.findUserByEmail(email);
        return userBO;
    }



    @Override
    public UserBO saveUser(UserBO user) {
        return userDomain.saveUser(user);
    }



    @Override
    public Page<UserBO> listUsers(Pageable pageable) {
    	Page<UserEntity> page = userDomain.listUsers(pageable);
    	List<UserBO> content = new ArrayList<UserBO>();
    	for (UserEntity user : page.getContent()) {
    		//Convert user entity to userbo
    	}
    	
    	Page<UserBO> returnPage = new PageImpl<UserBO>(content);
        return returnPage;
    }



    @Override
    public Page<UserBO> searchByTerm(String name, Pageable pageable) {
        return userDomain.searchByTerm(name, pageable);
    }



    @Override
    public Boolean removeAll() {
    	return userDomain.removeAll();
    }



    @Override
    public void removeById(Integer id) {
    	userDomain.removeById(id);
    }



    @Override
    public UserBO findById(Integer id) {
        return userDomain.findById(id);
    }



    @Override
    public List<UserBO> searchBy(String keyword, String criteria) {
        return userDomain.searchBy(keyword, criteria);

    }



	@Override
	public Page<UserBO> findAll(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
    
    

}