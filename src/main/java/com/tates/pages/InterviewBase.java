package com.tates.pages;

import org.openqa.selenium.By;

import com.tates.base.TestBase;

public class InterviewBase extends TestBase{
	
	By firsttext= By.xpath("//input[@placeholder='First Name']");
	
	public void followlink(String Value) {
		
		sendKeys(firsttext, Value, "Mili");
	}
	
	public void clickfollow() {
		
		followlink("");
	}

}
