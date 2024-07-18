package com.jfm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.jfm.base.TestBase;

public class WelcomePage extends TestBase {

	By myaccount = By.xpath("//main[@class='page-main']//li[2]//a[1]");

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