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

public class DeleteMiniCart extends TestBase {

	// Add Multiple product into the cart and delete it from Mini cart

	By shadeselector = By.xpath("//span[@class='swatch-attribute-selected-option']");

	By shampooshadeimage = By.xpath("//div[@id='option-label-color-90-item-13']//div[@class='img']");

	By combeinshadeimage = By.xpath("//div[@id='option-label-color-90-item-20']//div[@class='img']");

	By mnbshadeimage = By.xpath("//div[@id='option-label-beard_color-176-item-46']//div[@class='img']");

	By confirmshade = By.xpath("//span[@class='swatch-attribute-selected-option-select-btn']");

	By addtocartbutton = By.xpath("//button[@id='product-addtocart-button']");

	By continueshopping = By.xpath("//a[@class='action viewcart']//span[contains(text(),'continue shopping')]");

	By deletebutton = By.xpath("//li[1]//div[1]//div[1]//div[3]//div[2]//a[1]");

	By yesbutton = By.xpath("//span[contains(text(),'Yes')]");

	public void selectShadePopup(String ElementName) {
		click(shadeselector, ElementName);
	}

	public void shampooselectShadeImage(String ElementName) {
		click(shampooshadeimage, ElementName);
	}

	public void combeinselectShadeImage(String ElementName) {
		click(combeinshadeimage, ElementName);
	}

	public void mnbselectShadeImage(String ElementName) {
		click(mnbshadeimage, ElementName);
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

	public void clickOnDelete(String ElementName) {
		click(deletebutton, ElementName);
	}

	public void clickOnYes(String ElementName) {
		click(yesbutton, ElementName);
	}

	@Test
	public void minicartdelete() throws IOException, InterruptedException {

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

		selectShadePopup("Shampoo In Shade Selector");
		shampooselectShadeImage("Shampoo In Shade Image");
		confirmShade("Submit Shampoo In Shade");
		addtocart("Click on Add to Cart");

		// continue shopping
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

		selectShadePopup("Comb In Shade Selector");
		combeinselectShadeImage("Comb In Shade Image");
		confirmShade("Submit Comb In Shade");
		addtocart("Click on Add to Cart");

		// continue shopping
		sleep(2);
		continueShopping("click on continue shopping");

		// Mustache and Beard

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop Products')]")));

		WebElement shopproducts2 = driver.findElement(By.xpath("//a[contains(text(),'Shop Products')]"));

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(shopproducts2).build().perform();

		WebElement mandb = driver.findElement(By.xpath("//li[@id='menu-c1']//li[3]"));
		actions2.moveToElement(mandb).build().perform();
		mandb.click();

		actions2.click().build().perform();

		// Select Shade

		selectShadePopup("Mustache and Beard Shade Selector");
		mnbselectShadeImage("Mustache and Beard shade Image");
		confirmShade("Submit Shade");
		addtocart("Click on Add to Cart");

		// Verify the item details

		sleep(4);

		try {
			if (driver
					.findElements(
							By.xpath("//strong[@class='product-item-name']//a[contains(text(),'Mustache & Beard')]"))
					.size() != 0) {
				System.out.println("Mustache and Beard added successfully into the cart");
			}
			if (driver.findElements(By.xpath("//li[2]//div[1]//div[1]//strong[1]//a[1]")).size() != 0) {
				System.out.println("Easy Combe in added successfully into the cart");
			}
			if (driver.findElements(By.xpath("//li[3]//div[1]//div[1]//strong[1]//a[1]")).size() != 0) {
				System.out.println("Shampoo in color added successfully into the cart");
			} else {
				System.out.println("Products are not added successfully");
				Assert.fail("Catch FAIL: AddProductsInMiniCart");
			}
		} catch (Exception e) {
			System.out.println("FAIL: to verify the added product in the mini cart ");
			Assert.fail("Catch Fail - DeleteMiniCart");
		}

		// Delete Product from Mini cart

		clickOnDelete("Click on delete button");
		sleep(2);
		clickOnYes("Click Yes");
		
		sleep(7);

		try {
			if (driver
					.findElements(
							By.xpath("//strong[@class='product-item-name']//a[contains(text(),'Mustache & Beard')]"))
					.size() == 0) {
				System.out.println("Pass: Mustache and Beard removed successfully from the cart");
			} else {
				System.out.println("Fail: Mustache and Beard does not removed successfully from the cart");
				Assert.fail("Catch FAIL: DeleteProductsFromMiniCart");

			}
		} catch (Exception e) {
			System.out.println("FAIL: Mustache and Beard does not removed successfully from the cart ");
			Assert.fail("Catch Fail - DeleteProductsFromMiniCart");
		}

	}

}