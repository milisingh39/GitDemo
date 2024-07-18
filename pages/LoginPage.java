package com.jfm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jfm.base.TestBase;
import com.jfm.base.Utility;

public class LoginPage extends TestBase {

	Utility utility = new Utility();
	WelcomePage welcomepage = new WelcomePage();

	By myaccounticon = By.xpath("//a[@class='account-link ion-person']");

	By txtUsernameLocator = By.xpath("//input[@id='email']");

	By txtPasswordLocator = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");

	By btnLoginLocator = By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']");

	// By myaccount = By.xpath("//main[@class='page-main']//li[2]//a[1]");

	By loginpagetitle = By.xpath("//strong[contains(text(),'Returning Customers')]");

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
		click(btnLoginLocator, ElementName);
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
			openLoginPage("My Account Icon");
			enterUsername(prop1.getProperty("invalidUserName"));
			enterPassword(prop1.getProperty("invalidPassword"));
			clickOnLoginButton("login Button");
			if (getLoginPageTitle().equalsIgnoreCase("Returning customers")) {
				System.out.println("PASS: Invalid case is working successfully");
			} else {
				System.out.println("FAIL: Invalid case is not working properly");
				System.out.println("Expected title is - Returning customers.");
				System.out.println("Actual title is - " + getLoginPageTitle());
				Assert.fail("FAIL: loginWithInValidUsername ");
			}
		} catch (Exception e) {
			System.out.println("FAIL: to verify the invalid login");
			Assert.fail("Catch Fail - loginWithInValidData");
		}
		sleep(3);
	}

	public void loginWithInValidData2() throws InterruptedException {
		
		try {
			enterUsername(prop1.getProperty("username"));
			enterPassword(prop1.getProperty("invalidPassword"));
			clickOnLoginButton("login Button");
			if (getLoginPageTitle().equalsIgnoreCase("Returning customers")) {
				System.out.println("PASS: Invalid case is working successfully");
			} else {
				System.out.println("FAIL: Invalid case is not working properly");
				System.out.println("Expected title is - Returning customers.");
				System.out.println("Actual title is - " + getLoginPageTitle());
				Assert.fail("FAIL: loginWithInValidUsername ");
			}
		} catch (Exception e) {
			System.out.println("FAIL: to verify the invalid login");
			Assert.fail("Catch Fail - loginWithInValidData");
		}
		sleep(3);
	}

	public void loginWithInValidData3() throws InterruptedException {
		try {

			enterUsername(prop1.getProperty("invalidUserName"));
			enterPassword(prop1.getProperty("Password"));
			clickOnLoginButton("login Button");
			if (getLoginPageTitle().equalsIgnoreCase("Returning customers")) {
				System.out.println("PASS: Invalid case is working successfully");
			} else {
				System.out.println("FAIL: Invalid case is not working properly");
				System.out.println("Expected title is - Returning customers.");
				System.out.println("Actual title is - " + getLoginPageTitle());
				Assert.fail("FAIL: loginWithInValidUsername ");
			}
		} catch (Exception e) {
			System.out.println("FAIL: to verify the invalid login");
			Assert.fail("Catch Fail - loginWithInValidData");
		}
		sleep(3);
	}
}
