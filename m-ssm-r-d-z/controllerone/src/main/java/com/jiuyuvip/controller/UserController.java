package com.jiuyuvip.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuyuvip.entity.User;
import com.jiuyuvip.service.UserService;
  
/** 
 * ¹¦ÄÜ¸ÅÒª£ºUserController 
 *  
   */  
@Controller  
public class UserController {  
	
	 @Autowired
    private UserService userService;  
	 


      
    @RequestMapping("/user")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView();   
        try {
         	User user = userService.selectUserById(10);  
            mav.addObject("user", user);
            mav.setViewName("userinfor");
            
            
 		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mav.setViewName("404");
		}
         return mav;    
    }  
    
    
    @RequestMapping("/saveUser")   
    @ResponseBody
    public Object SaveUser(User user){      
        String s="ok"; 
        try {
        	userService.saveUser(user);
  		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
 		}
         return s;    
    } 
    
}  