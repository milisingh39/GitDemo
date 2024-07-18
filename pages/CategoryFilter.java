package com.jfm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfm.base.TestBase;



public class CategoryFilter extends TestBase {

	By shopproducts = By.xpath("//a[contains(text(),'Shop Products')]");

	By fullgraycoverage = By.xpath("//a[contains(text(),'Full Gray Coverage')]");

	By gradualgrayreduction = By.xpath("//a[contains(text(),'Gradual Gray Reduction')]");

	By allproducts = By.xpath("//a[contains(text(),'All Products')]");


	public void openShopProducts(String ElementName) {
		click(shopproducts, ElementName);
	}

	public void clickfullGrayCoverage(String ElementName) {
		click(fullgraycoverage, ElementName);
	}

	public void clickgradualGrayReduction(String ElementName) {
		click(gradualgrayreduction, ElementName);
	}

	public void clickallProducts(String ElementName) {
		click(allproducts, ElementName);
	}

	@Test

	public void categoryFilter() throws InterruptedException, IOException {

		openShopProducts("Shop Products");
		clickfullGrayCoverage("Full Gray Coverage");
		clickgradualGrayReduction("Gradual Gray Reduction");
		clickallProducts("All Products");

		sleep(2);
		try {
			if (driver.findElements(By.xpath("//div[2]//div[1]//select[1]")).size() != 0) {
				System.out.println("Pass: Products are sorted based on Product Name");
			}
		} catch (Exception e) {
			System.out.println("Fail: Produtcs are not sorted based on Product Name");
			System.out.println("Catch FAIL: Not able to login ");
			Assert.fail("Catch FAIL: loginWithValidData");
		}

		// select category landing
		
		sleep(3);

		WebElement shopproducts1 = driver.findElement(By.xpath("//a[contains(text(),'Shop Products')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shopproducts1).build().perform();

		WebElement gradualgray = driver.findElement(By.xpath("//span[contains(text(),'Gradual Grey Reduction')]"));
		actions.moveToElement(gradualgray).build().perform();
		gradualgray.click();

		actions.click().build().perform();

		for (int i = 0; i < 1500; i++) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2)", "");
		}

		String actualUrl = "https://jfm.combestaging.com/gradual-grey-reduction";
		String expectedUrl = driver.getCurrentUrl();

		try {
			if (actualUrl.equalsIgnoreCase(expectedUrl)) {
				System.out.println("Pass: Category landing page opened successfully");
			}
		} catch (Exception e) {
			System.out.println("Catch FAIL: Not able to open the category landing page");
			Assert.fail("Catch FAIL: CategoryPageNotOpened");
		}

	}

}
