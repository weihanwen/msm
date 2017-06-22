package ServiceTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiuyuvip.entity.User;
import com.jiuyuvip.service.UserService;

import controllerTest.SpringTestCase;
  
/** 
 * ���ܸ�Ҫ��UserService��Ԫ���� 
 *  
 * @author linbingwen 
 * @since  2015��9��28��  
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
			logger.debug("���ҽ��" + user.toString());  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }  
      
  
} 
