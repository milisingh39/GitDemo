package com.jfm.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfm.base.TestBase;

public class RegisterAtCheckOut extends TestBase {

	By shadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");

	By shampooshadeimage = By.xpath("//div[@id='option-label-color-90-item-13']//div[@class='img']");

	By combeinshadeimage = By.xpath("//div[@id='option-label-color-90-item-20']//div[@class='img']");

	By confirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");

	By freqselector = By.xpath("//div[@class='content']//div[@class='price']");

	By selectfreq = By.xpath("//div[@id='modal-content-26']//li[2]");

	By confirmfreq = By.xpath("//button[contains(text(),'Confirm Frequency')]");

	By addtocartbutton = By.xpath("//button[@id='product-addtocart-button']");

	By btnminicartcheckout = By.xpath("//button[@id='top-cart-btn-checkout']");
	
	By continueshopping = By.xpath("//a[@class='action viewcart']//span[contains(text(),'continue shopping')]");

	By btncreateanaccount = By.xpath("//span[contains(text(),'Create an Account')]");
	
	By firstnamelocator = By.xpath("//input[@id='firstname']");

	By lastnamelocator = By.xpath("//input[@id='lastname']");

	By emaillocator = By.xpath("//input[@id='email_address']");

	By passwordlocator = By.xpath("//input[@id='password']");

	By confirmpasswordlocator = By.xpath("//input[@id='password-confirmation']");

	By submitbutton = By.xpath("//button[@class='action submit primary']//span[contains(text(),'Create an Account')]");

	By street = By.xpath("//body/div/main/div/div/div/div/ol/li/div/form/div/fieldset/div/div[1]/div[1]/input[1]");

	By city = By.xpath("//div[@name='shippingAddress.city']//div//input[@name='city']");

	By zipcode = By.xpath("//div[@name='shippingAddress.postcode']//div//input[@name='postcode']");

	By phonenumber = By.xpath("//div[@name='shippingAddress.telephone']//div//input[@name='telephone']");

	By btncontinue = By.xpath("//button[@id='checkout-continue-next-step']");

	public void confirmRegistration(String ElementName) {
		click(btncreateanaccount, ElementName);
	}
	
	public void enterEmail(String value) {
		sendKeys(emaillocator, value, "email address");
	}

	public void enterFirstName(String value) {
		sendKeys(firstnamelocator, value, "firstname");
	}

	public void enterLastName(String value) {
		sendKeys(lastnamelocator, value, "lastname");
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
	
	public void enterStreet(String value) {
		sendKeys(street, value, "street");
	}

	public void enterCity(String value) {
		sendKeys(city, value, "city");
	}

	public void enterZipCode(String value) {
		sendKeys(zipcode, value, "zipcode");
	}

	public void enterPhoneNumber(String value) {
		sendKeys(phonenumber, value, "PhoneNumber");
	}

	public void continueToCheckOut(String ElementName) {
		click(btncontinue, ElementName);
	}

	public void selectShadePopup(String ElementName) {
		click(shadeselector, ElementName);
	}

	public void shampooselectShadeImage(String ElementName) {
		click(shampooshadeimage, ElementName);
	}

	public void combeinselectShadeImage(String ElementName) {
		click(combeinshadeimage, ElementName);
	}

	public void confirmShade(String ElementName) {
		click(confirmshade, ElementName);
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
	
	public void addtocart(String ElementName) {
		click(addtocartbutton, ElementName);
	}
	
	public void minicartCheckout(String ElementName) {
		click(btnminicartcheckout, ElementName);
	}

	public void continueShopping(String ElementName) {
		click(continueshopping, ElementName);
	}

	public void clickcreateanaccountinpopup(String ElementName) {
		click(btncreateanaccount, ElementName);
	}
	
	@Test

	public void registeratcheckout() throws InterruptedException, IOException {

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

		selectShadePopup("Shade Selector");
		shampooselectShadeImage("Shade Image");
		confirmShade("Submit Shade");
		addtocart("Click on Add to Cart");

		// click on continue shopping

		sleep(2);
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
		
		selectShadePopup("Shade Selector");
		combeinselectShadeImage("Shade Image");
		confirmShade("Submit Shade");
		clickonfreqpopup("Click on frequency popup");
		selectfreq("select frequency");
		confirmfreq("confirm frequency");
		addtocart("Click on Add to Cart");

		// Click on Proceed to checkout
		sleep(5);

		minicartCheckout("Proceed to checkout");

		// Create An Account PopUp

		sleep(2);
		clickcreateanaccountinpopup("Click on Create an account in the Popup");

		// Create An Account Page
		
		enterFirstName(prop1.getProperty("firstname"));
		enterLastName(prop1.getProperty("lastname"));
		
		// enterEmail(prop1.getProperty("Email"));
		
		FileReader f1 = new FileReader(new File("C:\\Jaimin\\AutoWorkSpace\\CombeAutomation\\Email_Id"));
		BufferedReader b1 = new BufferedReader(f1);

		String s = b1.readLine();
		f1.close();

		enterEmail(prop1.getProperty("Email") + s + "@sooryen.com");
		
		/*Actions email = new Actions(driver);
		email.moveToElement(driver.findElement(By.xpath("//input[@id='email_address']")));
		email.click();
		email.sendKeys(prop1.getProperty("Email") + s + "@sooryen.com");
		email.build().perform();*/
		
		FileWriter fw1 = new FileWriter(new File("C:\\Jaimin\\AutoWorkSpace\\CombeAutomation\\Email_Id"), false);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		int i = Integer.parseInt(s) + 1;
		bw1.write(String.valueOf(i));
		bw1.close();
		fw1.close();
		
		enterPassword(prop1.getProperty("Password"));
		enterConfirmPassword(prop1.getProperty("ConfirmPassword"));
		clickonsubmit("submit button");

		// Shipping Page

		sleep(15);

		enterStreet(prop1.getProperty("street"));
		enterCity(prop1.getProperty("city"));

		Select state = new Select(driver
				.findElement(By.xpath("//div[@name='shippingAddress.region_id']//div//select[@name='region_id']")));
		state.selectByVisibleText("California");

		enterZipCode(prop1.getProperty("zipcode"));
		enterPhoneNumber(prop1.getProperty("phonenumber"));
		
		/*sleep(4);
		WebElement shippingaddress = driver.findElement(By.xpath("//ol[@id='checkoutSteps']//tbody//tr[1]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(shippingaddress).click().perform();*/

		// Click on Continue Button
		
		sleep(8);
		
		WebElement continuebutton = driver.findElement(
				By.xpath("//button[@id='checkout-continue-next-step']//span[contains(text(),'Continue')]"));

		Actions actions3 = new Actions(driver);

		actions3.moveToElement(continuebutton).click().perform();

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

		// Clicking on Checkbox

		sleep(2);

		// driver.findElement(By.xpath("")).click();
		
		driver.findElement(By.id("0_agreement_braintree_1")).sendKeys(Keys.SPACE);

		// Placing an order

		driver.findElement(By.xpath("//button[@id='place-order-trigger']")).click();

		sleep(10);
		try {
			if (driver.findElements(By.xpath("//span[contains(text(),'Continue Shopping')]")).size() != 0) {
				System.out.println("Pass: Guest User Order Placed successfully");
			} else {
				System.out.println("Fail: Guest User order not placed succesfully");
			}
		} catch (Exception e) {
			System.out.println("Catch FAIL: Guest User order not placed succesfully");
			Assert.fail("Catch FAIL: RegisterAtCheckout");

		}
	}
}