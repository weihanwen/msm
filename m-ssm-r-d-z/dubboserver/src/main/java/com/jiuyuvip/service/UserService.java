package com.jiuyuvip.service;
 

 import com.jiuyuvip.entity.User;
  
/** 
 * ���ܸ�Ҫ��UserServiceʵ���� 
  */  
public interface UserService {  
 
    public User selectUserById(Integer user_id) throws Exception; 
    
    public void saveUser(User user) throws Exception; 
    
  
}