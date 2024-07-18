package com.tates.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.tates.base.TestBase;

public class WelcomePage extends TestBase {

	By myaccount = By.xpath("//span[contains(text(),'My Account')]");

	public void clickOnBuildButton() {
		click(myaccount, "Build Button");
	}

	public void verifySucessfulLogin() {
		WebElement element = isElementVisible(myaccount, "Build Button");
		if (element != null) {
			System.out.println("PASS: Verified successful login of user.");
		} else {
			System.out.println("FAIL: Not able to login ");
			Assert.fail("verifySucessfulLogin");
		}
	}

	
}