package ServiceTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiuyuvip.entity.User;
import com.jiuyuvip.service.UserService;

import controllerTest.SpringTestCase;
  
/** 
 * 功能概要：UserService单元测试 
 *  
 * @author linbingwen 
 * @since  2015年9月28日  
 */  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
    
      
    @Test  
    public void selectUserByIdTest(){  
        User user;
		try {
			user = userService.selectUserById(10);
			logger.debug("查找结果" + user.toString());  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }  
      
  
} 
