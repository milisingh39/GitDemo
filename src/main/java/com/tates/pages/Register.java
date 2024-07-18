package com.tates.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tates.base.TestBase;

public class Register extends TestBase {

	WelcomePage welcomepage = new WelcomePage();
	
	
	  By myaccounticon=By.xpath("//div[@class='account-top-wrapper']");
	  
	
	
	

	

	By createaccountbutton = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[2]/div[2]/div/div/a/span");

	By firstnamelocator = By.xpath("//input[@id='firstname']");

	By lastnamelocator = By.xpath("//input[@id='lastname']");

	By emaillocator = By.xpath("//input[@id='email_address']");

	By passwordlocator = By.xpath("//input[@id='password']");

	By confirmpasswordlocator = By.xpath("//input[@id='password-confirmation']");

	By submitbutton = By.xpath("//*[@id='form-validate']/div/div[1]/button/span");
	
	By myaccounttitle = By.xpath("//span[contains(text(),'My Account')]");
	
	By registerpagetitle = By.xpath("//span[contains(text(),'Create New Customer Account')]");
	
	 By NoThanks= By.xpath("//a[text()='No thanks']");

	public void openLoginPage(String ElementName) {
		click(myaccounticon, ElementName);
	}

	public void openRegisterPage(String ElementName) {
		click(createaccountbutton, ElementName);
	}

	public void enterFirstName(String value) {
		sendKeys(firstnamelocator, value, "firstname");
	}

	public void enterLastName(String value) {
		sendKeys(lastnamelocator, value, "lastname");
	}

	public void enterEmail(String value) {
		sendKeys(emaillocator, value, "email address");
	}

	public void enterPassword(String value) {
		sendKeys(passwordlocator, value, "password");
	}

	public void enterConfirmPassword(String value) {
		sendKeys(confirmpasswordlocator, value, "confirmpassword");
	}

	public void clickonsubmit(String ElementName) {
		click(submitbutton, ElementName);
	}
	
	public void clicknothanks(String ElementName) {
		click(NoThanks, "Popup");
	}
	public String getRegisterPageTitle() {
		return getText(registerpagetitle, "Create New Customer Account");
	}
	
	public void registerWithInValidData() throws InterruptedException {
		try {
			clicknothanks("Popup");
			sleep(10);
	        openLoginPage("My Account Icon");
			openRegisterPage("create an account button");
			enterFirstName(prop1.getProperty("firstname"));
			enterLastName(prop1.getProperty("lastname"));
			enterEmail(prop1.getProperty("Email"));
			enterPassword(prop1.getProperty("Password"));
			enterConfirmPassword(prop1.getProperty("invalidPassword"));
			clickonsubmit("submit button");

			if (getRegisterPageTitle().equalsIgnoreCase("Create New Customer Account")) {
				System.out.println("PASS: Not able to Register with Incorrect Details");
			} else {
				System.out.println("FAIL: Invalid case is not working properly");
				System.out.println("Expected title is - Returning customers.");
				System.out.println("Actual title is - " + getRegisterPageTitle());
				Assert.fail("FAIL: loginWithInValidUsername ");
			}
		} catch (Exception e) {
			System.out.println("FAIL: to verify the invalid Registration");
			Assert.fail("Catch Fail - registerWithInValidData");
		}
		sleep(3);

	}
	
	

	public void registerWithValidData() throws Exception {
		try {
			enterFirstName(prop1.getProperty("firstname"));
			enterLastName(prop1.getProperty("lastname"));
			String email= "sohil.memn" + Math.random() + "@encora.com";
			enterEmail(email);
			
			
			enterPassword(prop1.getProperty("Password"));
			enterConfirmPassword(prop1.getProperty("ConfirmPassword"));
			clickonsubmit("submit button");
			verifySucessfulRegistration();
			} catch (Exception e) {
			System.out.println("Catch FAIL: Not able to login ");
			Assert.fail("Catch FAIL:  Not able to Register");
		}
	}

	public void verifySucessfulRegistration() {
		WebElement element = isElementVisible(welcomepage.myaccount, "Build Button");
		if (element != null) {
			System.out.println("PASS: Verified successful registration of user.");
		} else {
			System.out.println("FAIL: Not able to Register ");
			Assert.fail("verifySucessfulRegistration");
		}
	}



	

}
