package com.jiuyuvip.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiuyuvip.entity.User;
import com.jiuyuvip.service.UserService;
  
/** 
 * ¹¦ÄÜ¸ÅÒª£ºUserController 
 *  
   */  
@Controller  
public class UserController {  
    @Resource  
    private UserService userService;  
      
    @RequestMapping("/user")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("404");   
        User user = userService.selectUserById(10);  
        System.out.println("99"+user.toString());
        mav.addObject("user", user);   
        return mav;    
    }    
}  