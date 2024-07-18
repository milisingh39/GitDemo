package com.tates.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tates.base.TestBase;
import java.util.List;
public class PDPPageBase extends TestBase {
    
    long waitTimeInSecs =20;
    public final static long WAIT_DEFAULT = 20;
   
    By myaccounticon=By.xpath("//div[@class='account-top-wrapper']");
    
	 By txtUsernameLocator = By.xpath("//input[@id='email']");
	 By txtPasswordLocator = By.xpath("//input[@id='pass']");
    By btnLoginLocator = By.xpath("//button[@name='send']");
    By NoThanks= By.xpath("//a[text()='No thanks']");
    By SearchBox = By.xpath("//input[@id='search']");
    By EnteredProduct=By.xpath("//*[@id='search_mini_form']/div[1]/div/div[1]/div[3]/div[1]/div[1]/div[1]/ul/li[1]/a/span[2]");
    By SearchBtn = By.xpath("//button[@title='Search']");
  
    
  
    By ProductName = By.xpath("//span[contains(text(),'Main Street Southampton Basket Large')]");
    By ProductPrice = By.xpath("//span[contains(text(),'$65')]");
    By AddtoCartBtn = By.xpath("//*[@id='product-addtocart-button']");
    By Cart= By.xpath("//a[@class='action showcart']");
    By Delete=By.xpath("//*[@id='shopping-cart-table']/tbody[1]/tr/td[5]/a/span/i");
   
  
    	
    
    public void openLoginPage(String ElementName) {
        click(myaccounticon, "My Account Icon");
    }



    public void enterUsername(String value) {
        sendKeys(txtUsernameLocator, value, "username");
    }
    



    public void enterPassword(String value) {
        sendKeys(txtPasswordLocator, value, "password");
    }



    public void clickOnLoginButton(String ElementName) {
        click(btnLoginLocator, "login Button");
    }
    
    public void clicknothanks(String ElementName) {
        click(NoThanks, "Popup");
    }
    public void EnterSearch(String value) {
        sendKeys(SearchBox, value, "Search");
    }
    public void Searchproduct(String ElementName)
    {
    	
    	click(EnteredProduct, "Auto Search");
    }
    public void clicksearch(String ElementName) {
        click(SearchBtn, "SearchBtn");
    }
    
     public String productnametext() {
         return getText(ProductName, "Name");             
    }
     public void productpricetext(String ElementName) {
        getText(ProductPrice, "Price");             
    }
 
     public void addtocartbtn(String ElementName) {
        click(AddtoCartBtn, "CartBtn");             
    }
     public void cart(String ElementName) {
         
         click(Cart,"MyCart");
     }
     
     public void deletebtton()
     {
    	 click(Delete, "Delete Button");
     }
  
    public void loginWithValidData() throws Exception {
    	
    	Thread.sleep(5000);
	    clicknothanks("Popup");
	    Thread.sleep(5000);
         
         openLoginPage("My Account Icon");
         enterUsername(prop2.getProperty("Email"));
          enterPassword(prop2.getProperty("Password"));
          clickOnLoginButton("login Button");
           }
    
    
    
    
    public void checkitem() throws Exception
    {
    	if (isDisplayed(Delete, WAIT_DEFAULT))
    	{
    		System.out.println("Product is already added so removing it");
    		 deletebtton();
    		
    	}
    	else {
    		
    		System.out.println("No Product is present in the cart");
    	}
    }
    
    public void Productcheck() throws Exception {
    	System.out.println("****Checking if any product in the cart****");
    	loginWithValidData();
        cart("MyCart");
        checkitem();
    }
    
    
    public void searchProduct() {
    	sleep(10);
    	EnterSearch("Main Street");
        Searchproduct("Auto Search");
        productnametext();
    	
    }
     
    
    
    
   public void ProductSelection() throws Exception {
       
       try {
       
    	    System.out.println("*********Adding the Product******");

    //EnterSearch("Main Street");
//    Searchproduct("Auto Search");
  // productnametext();
       productpricetext("Price");
       sleep(15);
       addtocartbtn("CartBtn"); 
       sleep(15);
       System.out.println("********Product is added*****");
       
        if(productnametext().equalsIgnoreCase("Main Street Southampton Basket Large"))
        {
            
            System.out.println("Pass: The Product Title is Correct");
        }
        else
        {
            System.out.println("Fail: The Product Title is Incorrect");
            Assert.fail("Fail: The Product Title is Incorrect");
        }
       }catch(Exception e)
       {
           Assert.fail("Fail: The Product Title is Incorrect");
       }
   }
}