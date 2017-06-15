package com.jiuyuvip.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jiuyuvip.dao.DaoSupport;
import com.jiuyuvip.entity.User;
  
/** 
 * 功能概要：UserService实现类 
  */  
@Service("userService")  
public class UserService {  
	
	@Resource(name = "daoSupport")
	private DaoSupport dao; 
  
	@Cacheable(value="User",key="'selectUserById'+#user_id") 
    public User selectUserById(Integer user_id) throws Exception {  
    	return (User)dao.findForObject("UserMapper.selectUserById", user_id);
    } 
 
	
	
 
  
}