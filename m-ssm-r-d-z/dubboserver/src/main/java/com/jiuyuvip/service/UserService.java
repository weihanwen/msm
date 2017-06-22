package com.jiuyuvip.service;
 

 import com.jiuyuvip.entity.User;
  
/** 
 * 功能概要：UserService实现类 
  */  
public interface UserService {  
 
    public User selectUserById(Integer user_id) throws Exception; 
    
    public void saveUser(User user) throws Exception; 
    
  
}