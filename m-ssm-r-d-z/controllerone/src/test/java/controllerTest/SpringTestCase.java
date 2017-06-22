package controllerTest;


import javax.servlet.jsp.tagext.PageData;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiuyuvip.entity.User;
import com.jiuyuvip.service.UserService;

/** 
* ���ܸ�Ҫ�� 
*  
* @author linbingwen 
* @since  2015��9��28��  
*/  
//ʹ�ñ�׼��JUnit @RunWithע��������JUnitʹ��Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
public abstract class SpringTestCase extends AbstractJUnit4SpringContextTests{  
  protected Logger logger = LoggerFactory.getLogger(getClass());  
  
  
  
  public static void main(String[] args) {
		  try {  
	          // ��ʼ��Spring  
	          ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext-dubbo.xml");  
	          UserService us=(UserService) ctx.getBean("userService") ;
	          User user=us.selectUserById(10);
	          System.out.println("user="+user.toString());   
	          System.in.read();  
	        } catch (Exception ex) {  
	          ex.printStackTrace();  
	        }  
 	}
}  