package Tates;

import org.testng.annotations.Test;

import com.tates.base.TestBase;
import com.tates.pages.Register;


public class RegisterPageTC2 extends TestBase {

	TestBase demobase = new TestBase();
	Register register = new Register();
	
	
	 @Test(priority = 1, enabled = true)
	public void  verifyRegisterWithInValidData() throws Exception{
	  System.out. println("********** Verifying  Registration with Invalid username **********");
	  register.registerWithInValidData();
	  }
	 
	@Test(priority = 2, enabled = true)
	public void verifyRegisterWithValidData() throws Exception {
		System.out.println("**********  Verifying  Registration of user with valid credentials**********");		
		register.registerWithValidData();
	}
	
	@Test(priority = 3, enabled = true)
	public void verifyRegisterSuccess() throws Exception {
		System.out.println("**********  Verifying successful Registration with valid credentials**********");		
		register.verifySucessfulRegistration();
	}
	
}
