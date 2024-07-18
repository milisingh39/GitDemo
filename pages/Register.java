package com.jfm.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jfm.base.TestBase;

public class Register extends TestBase {

	WelcomePage welcomepage = new WelcomePage();

	By myaccounticon = By.xpath("//a[@class='account-link ion-person']");

	By createaccountbutton = By.xpath("//a[@class='action create primary']");

	By firstnamelocator = By.xpath("//input[@id='firstname']");

	By lastnamelocator = By.xpath("//input[@id='lastname']");

	By emaillocator = By.xpath("//input[@id='email_address']");

	By passwordlocator = By.xpath("//input[@id='password']");

	By confirmpasswordlocator = By.xpath("//input[@id='password-confirmation']");

	By submitbutton = By.xpath("//button[@class='action submit primary']//span[contains(text(),'Create an Account')]");

	By myaccounttitle = By.xpath("//span[contains(text(),'My Account')]");

	By registerpagetitle = By.xpath("//span[contains(text(),'Create New Customer Account')]");

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

	public void registerWithValidData() throws Exception {
		try {
			// openLoginPage("My Account Icon");

			enterFirstName(prop1.getProperty("firstname"));
			enterLastName(prop1.getProperty("lastname"));

			FileReader f1 = new FileReader(new File("C:\\Jaimin\\AutoWorkSpace\\CombeAutomation\\Email_Id"));
			BufferedReader b1 = new BufferedReader(f1);

			String s = b1.readLine();
			f1.close();

			enterEmail(prop1.getProperty("Email") + s + "@sooryen.com");
			
			/*
			 * WebElement email1 =
			 * driver.findElement(By.xpath("//input[@id='email_address']")); email1.clear();
			 * Actions email11 = new Actions(driver);
			 * email11.moveToElement(driver.findElement(By.xpath(
			 * "//input[@id='email_address']"))); email11.click();
			 * email11.sendKeys(prop1.getProperty("Email") + s + "@sooryen.com");
			 * email11.build().perform();
			 */

			FileWriter fw1 = new FileWriter(new File("C:\\Jaimin\\AutoWorkSpace\\CombeAutomation\\Email_Id"), false);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			int i = Integer.parseInt(s) + 1;
			bw1.write(String.valueOf(i));
			bw1.close();
			fw1.close();

			enterPassword(prop1.getProperty("Password"));
			enterConfirmPassword(prop1.getProperty("ConfirmPassword"));
			clickonsubmit("submit button");
			verifySucessfulRegistration();

		} catch (Exception e) {
			System.out.println("Catch FAIL: Not able to login ");
			Assert.fail("Catch FAIL: loginWithValidData");
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

	public String getRegisterPageTitle() {
		return getText(registerpagetitle, "My Account");
	}

	public void registerWithInValidData() throws InterruptedException {
		try {
			openLoginPage("My Account Icon");
			openRegisterPage("create an account button");
			enterFirstName(prop1.getProperty("firstname"));
			enterLastName(prop1.getProperty("lastname"));
			enterEmail(prop1.getProperty("Email"));
			enterPassword(prop1.getProperty("Password"));
			enterConfirmPassword(prop1.getProperty("invalidPassword"));
			clickonsubmit("submit button");

			if (getRegisterPageTitle().equalsIgnoreCase("Create New Customer Account")) {
				System.out.println("PASS: Invalid case is working successfully");
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

}
