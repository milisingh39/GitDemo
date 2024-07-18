package Tates;

import org.testng.annotations.Test;

import com.tates.base.TestBase;
import com.tates.pages.InterviewBase;
import com.tates.pages.LoginPage;



public class LoginPage_TC1 extends TestBase
{
		//TestBase rpbase = new TestBase();
		//LoginPage loginpage = new LoginPage();
		InterviewBase ib= new InterviewBase();
	
		
		

	@Test(priority = 1, enabled = true)
		public void verifyLoginWithInValidData1() throws Exception {
			//System.out.println("********** Verifying with invalid Username & Password **********");
			//loginpage.loginWithInValidData1();
		ib.clickfollow();
			
		}
		
		@Test(priority = 2, enabled = false)
		public void verifyLoginWithInValidData2() throws Exception {
			System.out.println("********** Verifying  with Incorrect Password **********");
			loginpage.loginWithInValidData2();
		}

		@Test(priority = 3, enabled = false)
		public void verifyLoginWithInValidData3() throws Exception {
			System.out.println("********** Verifying  Incorrect Username **********");
			loginpage.loginWithInValidData3();
		}
		
		
		@Test(priority = 4, enabled = false)
		public void LoginwithBlankData() throws Exception {
			System.out.println("********** Verifying Login with Blank Data **********");
			loginpage.LoginwithBlankData();
		}
		
		@Test(priority =5 , enabled = false)
		public void verifyLoginWithValidData() throws Exception {
			System.out.println("********** Verifying successful login of user with valid credentials **********");
			loginpage.loginWithValidData();
		}*/
		
		
	}

	
