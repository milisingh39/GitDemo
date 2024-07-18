package com.jfm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfm.base.TestBase;

public class EditCart extends TestBase {

	By shampooshadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");

	By shampooshadeimage = By.xpath("//div[@id='option-label-color-90-item-13']//div[@class='img']");

	By shampooconfirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");

	By combeinshadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");

	By combeinshadeimage = By.xpath("//div[@id='option-label-color-90-item-20']//div[@class='img']");

	By combeinconfirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");

	By addtocartbutton = By.xpath("//button[@id='product-addtocart-button']");

	By continueshopping = By.xpath("//a[@class='action viewcart']//span[contains(text(),'continue shopping')]");

	By carticon = By.xpath("//i[@class='icon ion-android-cart']");

	By qtyincrease = By.xpath(
			"/html[1]/body[1]/div[6]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]");

	By cartupdate = By.xpath(
			"/html[1]/body[1]/div[6]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/button[1]");

	By deleteproduct = By.xpath(
			"//body/div/main[@id='maincontent']/div/div/div/form[@id='form-validate']/div/table[@id='shopping-cart-table']/tbody[1]/tr[1]/td[2]/div[1]/div[1]/a[1]");

	By couponcode = By.xpath("//input[@id='coupon_code']");

	By applycoupon = By.xpath("//form[@id='discount-coupon-form']//span[contains(text(),'Apply')]");

	public void shampooselectShadePopup(String ElementName) {
		click(shampooshadeselector, ElementName);
	}

	public void shampooselectShadeImage(String ElementName) {
		click(shampooshadeimage, ElementName);
	}

	public void shampooconfirmShade(String ElementName) {
		click(shampooconfirmshade, ElementName);
	}

	public void combeinselectShadePopup(String ElementName) {
		click(combeinshadeselector, ElementName);
	}

	public void combeinselectShadeImage(String ElementName) {
		click(combeinshadeimage, ElementName);
	}

	public void combeinconfirmShade(String ElementName) {
		click(combeinconfirmshade, ElementName);
	}

	public void addtocart(String ElementName) {
		click(addtocartbutton, ElementName);
	}

	public void continueShopping(String ElementName) {
		click(continueshopping, ElementName);
	}

	public void clickOnCart(String ElementName) {
		click(carticon, ElementName);
	}

	public void qtyIncrease(String ElementName) {
		click(qtyincrease, ElementName);
	}

	public void cartUpdate(String ElementName) {
		click(cartupdate, ElementName);
	}

	public void deleteCart(String ElementName) {
		click(deleteproduct, ElementName);
	}

	public void enterCoupon(String value) {
		sendKeys(couponcode, value, "coupon code");
	}

	public void applyCoupon(String ElementName) {
		click(applycoupon, ElementName);
	}

	@Test

	public void editcart() throws InterruptedException {

		// Create object of WebDriverWait class

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Select Shampoo in color

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop Products')]")));

		WebElement shopproducts = driver.findElement(By.xpath("//a[contains(text(),'Shop Products')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shopproducts).build().perform();

		WebElement shampooincolor = driver.findElement(By.xpath("//li[@id='menu-c1']//li[1]"));
		actions.moveToElement(shampooincolor).build().perform();
		shampooincolor.click();

		actions.click().build().perform();

		// Select Shade

		shampooselectShadePopup("Shampoo in Shade Selector");
		shampooselectShadeImage("Shampoo in Shade Image");
		shampooconfirmShade("Submit Shade");
		addtocart("Add to Cart");

		// click on continue shopping
		sleep(3);
		continueShopping("Continue shopping");

		// Combe in color

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop Products')]")));

		WebElement shopproducts1 = driver.findElement(By.xpath("//a[contains(text(),'Shop Products')]"));

		Actions actions1 = new Actions(driver);
		actions1.moveToElement(shopproducts1).build().perform();

		WebElement combincolor = driver.findElement(By.xpath("//li[@id='menu-c1']//li[2]"));
		actions1.moveToElement(combincolor).build().perform();
		combincolor.click();

		actions1.click().build().perform();

		// Select Shade

		combeinselectShadePopup("Combe in Shade Selector");
		combeinselectShadeImage("Combe in Shade Image");
		combeinconfirmShade("Submit Shade");
		addtocart("Add to Cart");

		// continue shopping
		sleep(3);
		continueShopping("Continue shopping");
		clickOnCart("click on cart icon");

		// Update product on cart page
		
		for (int i = 0; i < 3; i++) {

			qtyIncrease("Increase product qty");
		}
	
		
		
		cartUpdate("Update Cart Button");
		
		// Delete product from the cart

		// sleep(5);

		try {
			if (driver.findElements(By.xpath("//span[contains(text(),'$33.96')]"))
					.size() == 0) {
				System.out
						.println("Pass: Product Qty updated successfully");

			} else {
				System.out.println("Fail: Product Qty does not updated successfully");
				Assert.fail("Catch FAIL: ProductNotUpdated");
			}
		} catch (Exception e) {
			System.out.println("FAIL: Product Qty does not updated successfully ");
			Assert.fail("Catch Fail - ProductNotUpdated");
		}
		
		sleep(5);
		
		deleteCart("Delete product from cart");

		// Apply coupon code

		enterCoupon("oneoff");
		applyCoupon("Apply Coupon");

		try {
			if (driver.findElements(By.xpath("//span[@class='price'][contains(text(),'$7.49')]"))
					.size() == 0) {
				System.out
						.println("Pass: Combe in color product added succesfully into the cart and coupon code applied successfully");

			} else {
				System.out.println("Fail: Combe in color product not added into the cart");
				Assert.fail("Catch FAIL: ProductsNotAddedIntoCart");
			}
		} catch (Exception e) {
			System.out.println("FAIL: Combe in color product not added into the cart ");
			Assert.fail("Catch Fail - ProductsNotAddedIntoCart");
		}
		
		
	}

}
