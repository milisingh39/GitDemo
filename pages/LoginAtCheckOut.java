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

public class LoginAtCheckOut extends TestBase {

	By txtEmailLocator = By.xpath("//input[@id='customer-email']");

	By txtPasswordLocator = By.xpath("//input[@id='pass']");

	By shadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");

	By shampooshadeimage = By.xpath("//div[@id='option-label-color-90-item-13']//div[@class='img']");

	By combeinshadeimage = By.xpath("//div[@id='option-label-color-90-item-20']//div[@class='img']");

	By freqselector = By.xpath("//div[@class='content']//div[@class='price']");

	By selectfreq = By.xpath("//div[@id='modal-content-26']//li[2]");

	By confirmfreq = By.xpath("//button[contains(text(),'Confirm Frequency')]");

	By confirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");

	By addtocartbutton = By.xpath("//button[@id='product-addtocart-button']");

	By continueshopping = By.xpath("//a[@class='action viewcart']//span[contains(text(),'continue shopping')]");

	By btnminicartcheckout = By.xpath("//button[@id='top-cart-btn-checkout']");

	By btnLoginLocator = By.xpath("//button[@id='send2']");

	By couponcode = By.xpath("//input[@id='discount-code']");

	By btnapplycoupon = By.xpath("//button[@class='action action-apply']//span//span[contains(text(),'Apply')]");

	By btncontinue = By.xpath("//button[@id='checkout-continue-next-step']");
	
	By btnplaceorder = By.xpath("//button[@id='place-order-trigger']");
	

	public void selectShadePopup(String ElementName) {
		click(shadeselector, ElementName);
	}

	public void shampooselectShadeImage(String ElementName) {
		click(shampooshadeimage, ElementName);
	}

	public void combeinselectShadeImage(String ElementName) {
		click(combeinshadeimage, ElementName);
	}

	public void clickonfreqpopup(String ElementName) {
		click(freqselector, ElementName);
	}

	public void selectfreq(String ElementName) {
		click(selectfreq, ElementName);
	}

	public void confirmfreq(String ElementName) {
		click(confirmfreq, ElementName);
	}

	public void confirmShade(String ElementName) {
		click(confirmshade, ElementName);
	}

	public void addtocart(String ElementName) {
		click(addtocartbutton, ElementName);
	}

	public void continueShopping(String ElementName) {
		click(continueshopping, ElementName);
	}

	public void minicartCheckout(String ElementName) {
		click(btnminicartcheckout, ElementName);
	}

	public void enterEmail(String value) {
		sendKeys(txtEmailLocator, value, "email");
	}

	public void enterPassword(String value) {
		sendKeys(txtPasswordLocator, value, "password");
	}

	public void clickOnLoginButton(String ElementName) {
		click(btnLoginLocator, ElementName);
	}

	public void enterCoupon(String value) {
		sendKeys(couponcode, value, "coupon code");
	}

	public void clickonapplyCoupon(String ElementName) {
		click(btnapplycoupon, ElementName);
	}

	public void continueToCheckOut(String ElementName) {
		click(btncontinue, ElementName);
	}

	public void clickOnPlaceOrder(String ElementName) {
		click(btnplaceorder, ElementName);
	}
	
	@Test

	public void loginatcheckout() throws IOException, InterruptedException {

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

		selectShadePopup("Shampoo In Color Shade Selector popup ");
		shampooselectShadeImage("Shampoo In Color Shade Image");
		confirmShade("Submit Shade");
		addtocart("Click on Add to Cart");

		// click on continue shopping

		sleep(3);
		continueShopping("click on continue shopping");

		// Comb in color

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop Products')]")));

		WebElement shopproducts1 = driver.findElement(By.xpath("//a[contains(text(),'Shop Products')]"));

		Actions actions1 = new Actions(driver);
		actions1.moveToElement(shopproducts1).build().perform();

		WebElement combincolor = driver.findElement(By.xpath("//li[@id='menu-c1']//li[2]"));
		actions1.moveToElement(combincolor).build().perform();
		combincolor.click();

		actions1.click().build().perform();

		// Select Shade

		selectShadePopup("Comb In Color Shade Selector");
		combeinselectShadeImage("Comb In Color Shade Image");
		confirmShade("Submit Shade");
		clickonfreqpopup("Frequency popup");
		sleep(2);
		selectfreq("select frequency");
		sleep(2);
		confirmfreq("confirm frequency");
		sleep(2);
		addtocart("Click on Add to Cart");

		// Click on Proceed to checkout

		sleep(5);

		minicartCheckout("Proceed to checkout");

		// Login PopUp - Enter Email

		enterEmail(prop2.getProperty("Email"));
		enterPassword(prop2.getProperty("Password"));
		clickOnLoginButton("Click on Login Button");

		// Shipping Page

		sleep(10);
		enterCoupon("jfm90sale");
		sleep(5);
		clickonapplyCoupon("Apply coupon code");
		
		/*sleep(5);
		WebElement shippingaddress = driver.findElement(By.xpath("//ol[@id='checkoutSteps']//tbody//tr[1]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(shippingaddress).click().perform();*/
		
		// Click on Continue Button

		sleep(7);
		
		WebElement continuebutton = driver.findElement(
				By.xpath("//button[@id='checkout-continue-next-step']//span[contains(text(),'Continue')]"));

		Actions actions3 = new Actions(driver);

		actions3.moveToElement(continuebutton).click().perform();

		// continueToCheckOut("Click on Continue");

		// Enter Card

		sleep(7);

		driver.findElement(By.xpath("//a[contains(text(),'Credit Card')]")).click();

		/////
		
		driver.switchTo().frame("braintree-hosted-field-number");

		driver.findElement(By.id("credit-card-number")).sendKeys(prop1.getProperty("cardnumber"));

		driver.switchTo().defaultContent();

		driver.switchTo().frame("braintree-hosted-field-cvv");

		driver.findElement(By.id("cvv")).sendKeys(prop1.getProperty("cvv"));

		driver.switchTo().defaultContent();

		driver.switchTo().frame("braintree-hosted-field-expirationMonth");

		driver.findElement(By.id("expiration-month")).sendKeys(prop1.getProperty("expmonth"));

		driver.switchTo().defaultContent();

		driver.switchTo().frame("braintree-hosted-field-expirationYear");

		driver.findElement(By.id("expiration-year")).sendKeys(prop1.getProperty("expyear"));

		driver.switchTo().defaultContent();

		// Clicking on Checkbox

		// sleep(2);
		
		driver.findElement(By.id("0_agreement_braintree_1")).sendKeys(Keys.SPACE);

		// Placing an order
		
		WebElement placeorder = driver.findElement(By.xpath("//button[@id='place-order-trigger']"));

		Actions actions4 = new Actions(driver);

		actions4.moveToElement(placeorder).click().perform();

		// driver.findElement(By.xpath("//button[@id='place-order-trigger']")).click();

		sleep(10);
		
		try {
			if (driver.findElements(By.xpath("//span[contains(text(),'Continue Shopping')]")).size() != 0) {
				System.out.println("Pass: Login at Checkout and Order Placed successfully");
			} else {
				System.out.println("Fail: Login at Checkout and Order not Placed successfully");
			}
		} catch (Exception e) {
			System.out.println("Catch FAIL: Login at Checkout and Order not Placed successfully");
			Assert.fail("Catch FAIL: LoginAtCheckout");

		}

	}
}
