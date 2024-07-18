 package Tates;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.tates.base.TestBase;
import com.tates.pages.AddtocartPageBase;
import com.tates.pages.CheckoutPage;

public class Addtocart_TC4 extends TestBase{
	
	AddtocartPageBase ac= new AddtocartPageBase();
	
	
	@Test(priority=1, enabled=true)
	public void VerifyCartPage() throws Exception 
	{
		  System.out.println("**********Verifying  the calculations of Product Quantity**********");		  
		  ac.ProductInCart();
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyingProductTotal() {
		
		System.out.println("**********Verifying  the calculations of Product Total**********");
		ac.ProductTotal();
	}
}