package com.jfm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfm.base.TestBase;

public class LoggedInUserCheckout extends TestBase {

	By jfmlogo = By.xpath("//a[@class='logo']//img");

	By myaccounticon = By.xpath("//a[@class='account-link ion-person']");

	By txtUsernameLocator = By.xpath("//input[@id='email']");

	By txtPasswordLocator = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");

	By btnLoginLocator = By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']");

	By shadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");

	By shadeimage = By.xpath("//div[@id='option-label-color-90-item-13']//div[@class='img']");

	By confirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");

	By addtocartbutton = By.xpath("//button[@id='product-addtocart-button']");

	By qtyincrease = By.xpath("//div[@class='action qty-increase']");

	By carticon = By.xpath("//i[@class='icon ion-android-cart']");

	By btnminicartcheckout = By.xpath("//button[@id='top-cart-btn-checkout']");

	By checkoutbutton = By.xpath("//div[@class='cart-summary']//button[@class='action primary checkout']");

	// By btncontinue =
	// By.id("//button[@id='checkout-continue-next-step']//span[contains(text(),'Continue')]");

	By myorders = By.xpath("//main[@id='maincontent']//li[2]//a[1]");

	By myorderdropdown = By.xpath("//body/div/main/div/div/div/div/div[1]/div[1]/div[1]");

	By btnshippingmethod = By.xpath("//ol[@id='checkoutSteps']//tbody//tr[1]");

	public void clickOnLogo(String ElementName) {
		click(jfmlogo, ElementName);
	}

	public void openLoginPage(String ElementName) {
		click(myaccounticon, ElementName);
	}

	public void openMyAccount(String ElementName) {
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

	public void selectShadePopup(String ElementName) {
		click(shadeselector, ElementName);
	}

	public void selectShadeImage(String ElementName) {
		click(shadeimage, ElementName);
	}

	public void confirmShade(String ElementName) {
		click(confirmshade, ElementName);
	}

	public void qtyIncrease(String ElementName) {
		click(qtyincrease, ElementName);
	}

	public void addtocart(String ElementName) {
		click(addtocartbutton, ElementName);
	}

	public void minicartCheckout(String ElementName) {
		click(btnminicartcheckout, ElementName);
	}

	public void clickOnCheckOut(String ElementName) {
		click(checkoutbutton, ElementName);
	}

	public void clickOnCart(String ElementName) {
		click(carticon, ElementName);
	}

	/*
	 * public void continuetocheckout(String ElementName) { click(btncontinue,
	 * ElementName); }
	 */

	public void clickOnMyOrders(String ElementName) {
		click(myorders, ElementName);
	}

	public void clickOnOrderDropDown(String ElementName) {
		click(myorderdropdown, ElementName);
	}

	public void clickOnShippingMethod(String ElementName) {
		click(btnshippingmethod, ElementName);
	}

	@Test

	public void loggedInUserCheckout() throws IOException, InterruptedException {

		// Create object of WebDriverWait class

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Wait till the element is not visible

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='account-link
		// ion-person']"))).click();

		openLoginPage("My Account Icon");

		// Enter email

		enterUsername(prop2.getProperty("Email"));
		enterPassword(prop2.getProperty("Password"));
		clickOnLoginButton("login Button");

		// Select product

		sleep(3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop Products')]")));

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
		qtyIncrease("Increase Qty");

		// Verify PDP Details

		if (driver.findElements(By.xpath("//main[@id='maincontent']//span[contains(text(),'Shampoo-in Color')]"))
				.size() != 0) {
			System.out.println("Shampoo-in-color product page opened succesfully");
		} else {
			System.out.println("Shampoo-in-color product page not opened successfully");
		}

		// Add to Cart

		addtocart("Click on Add to Cart");

		// Click on proceed to checkout button in Mini Cart

		sleep(2);

		minicartCheckout("Mini Cart Proceed to checkcout");

		// Verify Added Product Cart Details

		sleep(15);

		clickOnLogo("Click on JFM Logo");
		clickOnCart("click on cart icon");

		sleep(9);

		if (driver.findElements(By.xpath("//td[@class='col item']//a[contains(text(),'Shampoo-in Color')]"))
				.size() != 0) {
			System.out.println("Shampoo-in-color product added succesfully into the cart");
		} else {
			System.out.println("Shampoo-in-color product not added successfully into the cart");
		}

		// Click on proceed to checkout button

		clickOnCheckOut("Proceed to Checkout");

		// click to continue

		sleep(7);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='value'][contains(text(),'2')]")));

		if (driver.findElements(By.xpath("//span[@class='value'][contains(text(),'2')]")).size() != 0) {
			System.out.println("Shampoo-in-color product qty is proper");
		} else {
			System.out.println("Shampoo-in-color product qty is not proper");
		}

		// sleep(7);
		// clickOnShippingMethod("Click on shipping method");
		// driver.findElement(By.xpath("//ol[@id='checkoutSteps']//tbody//tr[1]")).click();

		sleep(7);

		WebElement continuebutton = driver.findElement(
				By.xpath("//button[@id='checkout-continue-next-step']//span[contains(text(),'Continue')]"));

		Actions actions1 = new Actions(driver);

		actions1.moveToElement(continuebutton).click().perform();

		/*
		 * sleep(7); continuetocheckout("Click on Continue");
		 */
		
		// Enter Card

		sleep(10);

		driver.findElement(By.xpath("//a[contains(text(),'Credit Card')]")).click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Credit
		// Card')]"))).click();

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

		WebElement placeorder = driver.findElement(By.xpath("//button[@id='place-order-trigger']"));

		Actions actions4 = new Actions(driver);

		actions4.moveToElement(placeorder).click().perform();

		// Verify My Orders

		openMyAccount("Open My account");
		clickOnMyOrders("Click on My Orders");
		clickOnOrderDropDown("Click on order drop down");

		// Verify Placed Order

		try {
			if (driver
					.findElements(By.xpath(
							"//body/div/main/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/strong[1]"))
					.size() != 0) {
				System.out.println("Pass: Order placed successfully and display proper in My Orders ");
			} else {
				System.out.println("Order is not displayed in My orders");
			}
		} catch (Exception e) {
			System.out.println("Catch FAIL: Order is not displayed in My orders");
			Assert.fail("Catch FAIL: LoggedInUserCheckout");

		}

	}

}
