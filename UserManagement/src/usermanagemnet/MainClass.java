package usermanagemnet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String a[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDao UserDaoObj =  (UserDao)context.getBean("userDao");
		UserDaoObj.createUser("Ashok", "Password");
	}
	
}
