package com.tates.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.tates.base.TestBase;
import com.tates.base.Utility;

public class LoginPage extends TestBase {

	Utility utility = new Utility();
	WelcomePage welcomepage = new WelcomePage();
	//By myaccounticon=By.xpath("/html[1]/body[1]/div[4]/header[1]/div[1]/div[2]/a[1]");
	
	//  By myaccounticon=By.xpath("//a[@href='https://tates-m2-uat.encora.com/customer/account/']");
	By myaccounticon=By.xpath("//div[@class='account-top-wrapper']/a");
	    By txtUsernameLocator = By.xpath("//input[@id='email']");
	    By txtPasswordLocator = By.xpath("//input[@id='pass']");
	    By btnLoginLocator = By.xpath("//button[@name='send']");
	
	 By NoThanks= By.xpath("//a[text()='No thanks']");
			

	By loginpagetitle = By.xpath("//strong[contains(text(),'Already registered?')]");
	
	

	public String loginPageTitle() {
		return driver.getTitle();
	}

	public void openLoginPage(String ElementName) {
		click(myaccounticon, ElementName);
	}

	public void enterUsername(String value) {
		sendKeys(txtUsernameLocator, value, "username");
	}

	public void enterPassword(String value) {
		sendKeys(txtPasswordLocator, value, "password");
	}

	public void clickOnLoginButton(String ElementName) {
		click(btnLoginLocator, "login Button");
	}
	
	public void clicknothanks(String ElementName) {
		click(NoThanks, "Popup");
	}

	public void loginWithValidData() throws Exception {
		try {
			// openLoginPage("My Account Icon");
			enterUsername(prop2.getProperty("Email"));
			enterPassword(prop2.getProperty("Password"));
			clickOnLoginButton("login Button");
			verifySucessfulLogin();
		} catch (Exception e) {
			System.out.println("Catch FAIL: Not able to login ");
			Assert.fail("Catch FAIL: loginWithValidData");
		}
	}
	
	
	public void LoginwithBlankData()
	{
		try {
		enterUsername("");
		enterPassword("");
		clickOnLoginButton("login Button");
		if (getLoginPageTitle().equalsIgnoreCase("ALREADY REGISTERED?")) {
            System.out.println("PASS: User is Unable to Login with Blank Details");
        } else {
            System.out.println("FAIL: Invalid case is not working properly");
            System.out.println("Expected title is - ALREADY REGISTERED?");
            System.out.println("Actual title is - " + getLoginPageTitle());
           Assert.fail("FAIL: LoginwithBlankData ");
        }
		} catch(Exception e) {
			
			System.out.println("FAIL: to verify the invalid login");
	           Assert.fail("Catch Fail - LoginwithBlankData");
		}
	}

	public void verifySucessfulLogin() {
		WebElement element = isElementVisible(welcomepage.myaccount, "Build Button");
		if (element != null) {
			System.out.println("PASS: Verified successful login of user.");
		} else {
			System.out.println("FAIL: Not able to login ");
			Assert.fail("verifySucessfulLogin");
		}
		
	}

	public String getLoginPageTitle() {
		return getText(loginpagetitle, "login error");
	}

	public void loginWithInValidData1() throws InterruptedException {
		try {
			Thread.sleep(5000);
		    clicknothanks("Popup");
		    Thread.sleep(5000);
			openLoginPage("My Account Icon");
            enterUsername(prop1.getProperty("invalidUserName"));
            enterPassword(prop1.getProperty("invalidPassword"));
            clickOnLoginButton("login Button");
            if (getLoginPageTitle().equalsIgnoreCase("ALREADY REGISTERED?")) {
                System.out.println("PASS: Invalid case is working successfully");
            } else {
                System.out.println("FAIL: Invalid case is not working properly");
                System.out.println("Expected title is - ALREADY REGISTERED?");
                System.out.println("Actual title is - " + getLoginPageTitle());
               Assert.fail("FAIL: loginWithInValidUsername ");
            }
        } catch (Exception e) {
            System.out.println("FAIL: to verify the invalid login");
           Assert.fail("Catch Fail - loginWithInValidData");
        }
       // sleep(3);
    }

 

    public void loginWithInValidData2() throws InterruptedException {

 

        try {
        	
            enterUsername(prop1.getProperty("username"));
            enterPassword(prop1.getProperty("invalidPassword"));
            clickOnLoginButton("login Button");
            if (getLoginPageTitle().equalsIgnoreCase("ALREADY REGISTERED?")) {
                System.out.println("PASS: Invalid case is working successfully");
            } else {
                System.out.println("FAIL: Invalid case is not working properly");
                System.out.println("Expected title is - ALREADY REGISTERED?");
                System.out.println("Actual title is - " + getLoginPageTitle());
              Assert.fail("FAIL: loginWithInValidUsername ");
            }
        } catch (Exception e) {
            System.out.println("FAIL: to verify the invalid login");
            Assert.fail("Catch Fail - loginWithInValidData");
        }
        //sleep(3);
    }

 

    public void loginWithInValidData3() throws InterruptedException {
        try {

 
            
            enterUsername(prop1.getProperty("invalidUserName"));
            enterPassword(prop1.getProperty("Password"));
            clickOnLoginButton("login Button");
            if (getLoginPageTitle().equalsIgnoreCase("ALREADY REGISTERED?")) {
                System.out.println("PASS: Invalid case is working successfully");
            } else {
                System.out.println("FAIL: Invalid case is not working properly");
                System.out.println("Expected title is - ALREADY REGISTERED?");
                System.out.println("Actual title is - " + getLoginPageTitle());
                Assert.fail("FAIL: loginWithInValidUsername");
            }
        } catch (Exception e) {
            System.out.println("FAIL: to verify the invalid login");
            Assert.fail("Catch Fail - loginWithInValidData");
        }
       // sleep(3);
    }
}
 
			
			