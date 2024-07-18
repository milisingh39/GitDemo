package com.tates.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import com.tates.base.TestBase;
import java.util.List;
public class AddtocartPageBase extends TestBase {
    
    long waitTimeInSecs =20;
    public final static long WAIT_DEFAULT = 20;
   // By myaccounticon=By.xpath("//div[@class='account-top-wrapper']");
    By myaccounticon=By.xpath("//a[@href='https://tates-m2-uat.encora.com/customer/account/']");

  //a[@href='https://tates-m2-uat.encora.com/customer/account/']
    By txtUsernameLocator = By.xpath("//input[@id='email']");
    By txtPasswordLocator = By.xpath("//input[@id='pass']");
    By btnLoginLocator = By.xpath("//button[@name='send']");
    By NoThanks= By.xpath("//a[text()='No thanks']");
   
    By ProductPrice = By.xpath("//span[contains(text(),'$65')]");
    By AddtoCartBtn = By.xpath("//span[contains(text(),'Add to Cart')]");
    By Cart= By.xpath("//a[@class='action showcart']");
     By price = By.xpath("//*[@id='shopping-cart-table']/tbody[1]/tr/td[2]/span/span/span");
    By subtotal=By.xpath("//*[@id='shopping-cart-table']/tbody[1]/tr/td[4]/span/span/span");
    By GrandTotal= By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[3]/td/strong/span");
    By UpdateQty = By.xpath("//input[@title='Qty']");
    By Save = By.xpath("//*[@id='shopping-cart-table']/tbody[1]/tr/td[3]/a");
    By amount=By.xpath("//td[@class='amount']/span");
    

   
    
    
    public void openLoginPage(String ElementName) {
        click(myaccounticon, ElementName);
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
    
   
 
     public void addtocartbtn(String ElementName) {
        click(AddtoCartBtn, "CartBtn");             
    }
    public void cart(String ElementName) {
        
        click(Cart,"MyCart");
    }
   
    public String checkprice() {
       return getText(price, "Price");         
    }
    public String  checksubtotal() {
        return getText(subtotal, "Sub Total");        
    }
    
    public String checkgrandtotal() {
        return getText(GrandTotal, "Grand Total");        
    }
   
  
    public void quantity(String value) {
        sendKeys(UpdateQty, value, "Qtty");             
    }
    public void savebutton(String ElementName) {
        click(Save, "SaveButton");      
        
    }
   public void loginWithValidData() throws Exception {
          sleep(5);
           clicknothanks("Popup");
           sleep(10);
           openLoginPage("My Account Icon");
           enterUsername(prop2.getProperty("Email"));
           enterPassword(prop2.getProperty("Password"));
           clickOnLoginButton("login Button");
           }
    
   
   

   public void ProductInCart() throws Exception {
       loginWithValidData();
       cart("MyCart");
       sleep(15);
       quantity("3");
       System.out.println("**********Updated the Quantity as 3 **********");
         sleep(15);
       savebutton("SaveButton");
     

        
    	
    	try {
    	   System.out.println("**********Verifying the Product Total**********");
    	   
    		
    		
    		double sum=0;
    		
    	
    	   Thread.sleep(5000);
    	      
    	 String a = checkprice();
    	 System.out.println("Price for 1 Basket is :" +a);
    	 
    	 String priceone = a.replace("$","");
    	 double so=Double.parseDouble(priceone); 
    	 System.out.println("Price for 1 Basket is now  :" +so);
    	 
    	 sum = so * 3;
     sleep(10);
    	 
    	 System.out.println("One Basket updated with 3 quantity for purchasing and the price should be :" +sum);
    	 
    	   String b = checksubtotal();
    	   System.out.println("Subtotal for 3 Basket is :" +b);
    	   
    	   String pricethree = b.replace("$","");
		   double sos=Double.parseDouble(pricethree);
		      
			System.out.println("Price for 3 Basket is now  :" +sos);
    	   
    	   
    	
    	   if (sum == sos)
    	   {
    		   System.out.println("For 3 Quantity the price is Correct");
    		  
       		 
    	   }else
    	   {
    		   
    		   System.out.println("Price is Incorrect");
    		   Assert.fail("After Updating the Total Price is Incorrect");
    	   }
    	} catch(Exception e)
    	   {
    		   Assert.fail("After Updating the Total Price is Incorrect");
    	   }
    	  
    	 
 	}
       
 
   
   
   public void ProductTotal()
   {
	try{
		 sleep(10);
		 System.out.println("Calculating the Total with adding Shipping Charges");
		
         double sum=0;
   	      List<WebElement> amt= getVisibleElementLists(amount,"Totals");
   		  for(int i=0; i<amt.size();i++) {
   		
   			
   			String value= amt.get(i).getText();
   			System.out.println("The price are" +value);
   			
   		    String s = value.replace("$","");
   			double ss=Double.parseDouble(s);
   		  
   		
   			
   			 sum= sum + ss;
   		}
   			 System.out.println("SubTotal is :" +sum);
   			

   			 String t= checkgrandtotal();
   			 System.out.println("Grand Total is : " +t);
   			 
   			 String gt=t.replace("$", "");
   			 double st= Double.parseDouble(gt);
   			 
   			 System.out.println("Grand Total now is: " +st);
   			 
   			 
   		 if (sum == st)
   			 {
   				 
   				
   				 System.out.println("Total after adding Shipping Charges is correct");
   			 }
   			 else
   			 {
   				 System.out.println("Total after adding Shipping Charges is Incorrect");
   				 Assert.fail("Total after adding Shipping Charges is Incorrect");
   			 }
   			 
   	}catch(Exception e)
   	{
   		Assert.fail("Total after adding Shipping Charges is Incorrect");
   	}
		}
}