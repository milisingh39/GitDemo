package com.jfm.pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfm.base.TestBase;


public class UpdateMiniCart extends TestBase {

	 By shadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");
	 
	 By shadeimage = By.xpath("//div[@id='option-label-color-90-item-13']//div[@class='img']");
	 
	 By confirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");
	 
	 By addtocartbutton = By.xpath("//button[@id='product-addtocart-button']");
	 
	 By updatebutton = By.xpath("//li[1]//div[1]//div[1]//div[2]//div[1]//button[1]//span[1]");
	 
	 By couponcode = By.xpath("//input[@id='minicart-coupon-code']");
	 
	 By applycoupon = By.xpath("//button[@class='action action-apply']");
	 
	 By continueshopping = By.xpath("//a[@class='action viewcart']//span[contains(text(),'continue shopping')]");
	 
	 By carticon = By.xpath("//i[@class='icon ion-android-cart']");
	 
	 By qtyincrease = By.xpath("/html[1]/body[1]/div[6]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]");
	 
	 By cartupdate = By.xpath("/html[1]/body[1]/div[6]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/button[1]");
	 
	 By checkoutbutton = By.xpath("//div[@class='cart-summary']//button[@class='action primary checkout']");
	 
	 public void selectShadePopup(String ElementName) {
			click(shadeselector, ElementName);
		}
	 
	 public void selectShadeImage(String ElementName) {
			click(shadeimage, ElementName);
		}
	 
	 public void confirmShade(String ElementName) {
			click(confirmshade, ElementName);
		}
	 
	 public void addtocart(String ElementName) {
		 click(addtocartbutton, ElementName);
	 }
	 
	 public void clickOnUpdate(String ElementName) {
			click(updatebutton, ElementName);
		}
	 
	 public void enterCoupon(String value) {
			sendKeys(couponcode, value, "coupon code");
		}
	 
	 public void applyCoupon(String ElementName) {
			click(applycoupon, ElementName);
		}
	 
	 public void continueShopping(String ElementName) {
		 click(continueshopping, ElementName);
	 }
	 
	 public void clickOnCart(String ElementName) {
		 click(carticon,ElementName);
	 }
	 
	 public void qtyIncrease(String ElementName) {
		 click(qtyincrease, ElementName);
	 }

	 public void cartUpdate(String ElementName) {
		 click(cartupdate, ElementName);
	 }
	 
	 public void clickOnCheckOut(String ElementName) {
		 click(checkoutbutton, ElementName);
	 }
	 
	 
	@Test

	public void minicartupdate() throws IOException, InterruptedException {

		WebElement shopproducts = driver.findElement(By.xpath("//a[contains(text(),'Shop Products')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shopproducts).build().perform();

		WebElement shampooincolor = driver.findElement(By.xpath("//li[@id='menu-c1']//li[1]"));
		actions.moveToElement(shampooincolor).build().perform();
		shampooincolor.click();

		actions.click().build().perform();

		// Select Shade

		selectShadePopup("Shade Selector");
		selectShadeImage("Shade Image");
		confirmShade("Submit Shade");
		addtocart("Click on Add to Cart");
		// clickOnCart("click on cart icon");
		
		
		// update mini cart
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html[1]/body[1]/div[5]/header[1]/div[2]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/input[1]")));

		WebElement updateqty = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[5]/header[1]/div[2]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
		updateqty.sendKeys(Keys.BACK_SPACE);
		updateqty.sendKeys("2");

		// Update Qty
		
		clickOnUpdate("Click on update button");
		enterCoupon("oneoff");
		applyCoupon("Apply Coupon");
		
		sleep(3);

		if (driver.findElements(By.xpath("//span[contains(text(),'$15.98')]")).size() != 0) {
			System.out.println("Order total is proper");
		} else {
			System.out.println("Order total is not proper");
			Assert.fail("Catch FAIL: WrongOrderTotalInCart");
		}

		// click on continue shopping

		continueShopping("click on continue shopping");
		clickOnCart("click on cart icon");

		// Update product on cart page

		qtyIncrease("Increase Product Qty");
		cartUpdate("Update Cart Button");

		sleep(9);
		
		// Click on Checkout
		
		clickOnCheckOut("Proceed to Checkout");
		
		sleep(10);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Shampoo-in Color')]")));

		try {
		if (driver.findElements(By.xpath("//strong[contains(text(),'Shampoo-in Color')]")).size() != 0) {
			System.out.println("Shampoo-in-color product added succesfully with 3 Qty");
		}else {
				System.out.println("Shampoo-in-color product not added into the cart");
				Assert.fail("Catch FAIL: ProductNotAddedInToTheCart");
			}
		}
		catch (Exception e) {
			System.out.println("FAIL: to verify the product qty in the cart ");
			Assert.fail("Catch Fail - updateMiniCart");
		}
		
	}
	}

