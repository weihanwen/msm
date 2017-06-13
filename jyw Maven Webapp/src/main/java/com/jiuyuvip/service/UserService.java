package com.jiuyuvip.service;

import com.jiuyuvip.entity.User;

   
  
/** 
 * 功能概要：UserService接口类 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public interface UserService {  
    User selectUserById(Integer userId);  
  
}