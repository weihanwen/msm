package com.jiuyuvip.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jiuyuvip.dao.DaoSupport;
import com.jiuyuvip.entity.User;
  
/** 
 * ���ܸ�Ҫ��UserServiceʵ���� 
  */  
public interface UserService {  
 
    public User selectUserById(Integer user_id) throws Exception; 
  
}