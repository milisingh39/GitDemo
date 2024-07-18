 package com.tates.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tates.base.TestBase;
import java.util.List;
public class CheckoutPage extends TestBase {
	long waitTimeInSecs =20;
	 public final static long WAIT_DEFAULT = 20;
	 
     //By myaccounticon = By.xpath("//header/div[1]/div[3]/a[1]");
	 By myaccounticon=By.xpath("//div[@class='account-top-wrapper']");
	 By txtUsernameLocator = By.xpath("//input[@id='email']");
	 By txtPasswordLocator = By.xpath("//input[@id='pass']");
     By btnLoginLocator = By.xpath("//button[@name='send']");
     By NoThanks= By.xpath("//a[text()='No thanks']");
	 By Cart= By.xpath("//a[@class='action showcart']");
	 By checkoutbutton=By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[3]/ul/li[1]/button/span");	
	

	 By amounts=By.xpath("//td[@class='amount']/span");
	 By GrandTotal= By.xpath("//*[@id='opc-sidebar']/div[2]/div/table/tbody/tr[3]/td/strong/span");
	
	 By ContinueButton= By.xpath("//button[@class='button action continue primary']");
     By ShippingAddress=By.xpath("//*[@id='shipping']/div[3]/div/div/div");
     By Giftmessage=By.xpath("//*[@id='checkout-step-shipping_method']/div[2]/label");
     By Gifttext=By.xpath("//*[@id='gift-message-whole-message']");
     By cofirmGiftText=By.xpath("//*[@id='opc-shipping_method']/div/div[3]/div[2]/div");
     By deliverydate=By.xpath("//*[@id='opc-shipping_method']/div/div[3]/div[1]/div/div/span");
     By BillingInfo=By.xpath("//*[@id='billing']/div[3]/div");
     
     By Creditfield=By.xpath("//*[@id='payment-tabs-titles-wrapper']/ul/li[1]/a");
     By CreditName=By.xpath("//*[@id='authnetcim-cc-owner']");
     By CCNumber=By.xpath("//*[@id='authnetcim-cc-number']");
     By month=By.xpath("//*[@id='authnetcim-cc-exp-month']");
     By year=By.xpath("//*[@id='authnetcim-cc-exp-year']");
     By Cvv=By.xpath("//*[@id='authnetcim-cc-cid']");
     By PlaceOrderButton=By.xpath("//*[@id='checkout-step-payment']/div[2]/div[3]/div/button");
     
     By OrderVerifyText=By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/p[1]");
     By OrderNumber=By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/p[3]/a/strong");
   
     
     
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
 	public void cart(String ElementName) {
 		
 		click(Cart,"MyCart");
 	}
 	
 	public void CheckoutButton(String ElementName) {
 		click(checkoutbutton, "Checkout");
 	}
 	
 	public String Total(String ElementName)
 	{
 		
 		return getText(GrandTotal,"Checkout Total");
 	} 	
 	
 	public void  BillingAddress(String ElementName) {
 		 getText(ShippingAddress,"Checkout Total");
 	}
 	public void Gift(String value) {
 		
 		sendKeys(Gifttext,value,"GiftMessage");
 	
 	}
 	public void GiftMessageCheckbox(String ElementName) {
 	click(Giftmessage, "Message Checkbox");
 	}
 	public void GiftMessage(String ElementName) {
 		
 		getText(cofirmGiftText,"Message");
 	}
 	
 	public void DeliverydateText(String ElementName) {
 	  getText(deliverydate,"Date of Delivery");
 	}
 	public void BillingInformation(String ElementName) {
 		getText(BillingInfo, "BillingText");
 	}
 	 public void SelectPayment(String ElementName) {
    	 click(Creditfield, "SelectPayment");
     }
     public void NameonCC(String Value) {
     sendKeys(CreditName, Value, "NameonCC");    
     }
     public void CreditCardNumber(String Value) {
         sendKeys(CCNumber, Value, "CreditCardNumber");    
         }
     public void Month(String text) {
    	 Dropdown_Selection_by_Text(month, text); 
         }
     public void Year(String text) {
    	 Dropdown_Selection_by_Text(year, text); 
         }
     public void CvvNumber(String Value) {
         sendKeys(Cvv, Value, "CvvNumber");    
         }
     public void PlaceOrder(String ElementName) {
    	 
    	 click(PlaceOrderButton, "PlaceOrder");
     }
 	
public void OrderText(){
    	 
    	 getText(OrderVerifyText, "OrderText");
    	 
     }
     public String Ordernumber()
     {
    	return getText(OrderNumber, "Ordernumber") ;
     }
     
    
       
 	
 	
 	public void Recipient(String ElementName) {
 		List <WebElement> allContinueButton= getVisibleElementLists(ContinueButton, "Continue Button");
 		for( int i=0;i<= allContinueButton.size();i++)
 		{
 			
 			if (isElementVisible(allContinueButton.get(i), "ContinueButton", waitTimeInSecs))
 			{
 				allContinueButton.get(i).click();
 				sleep(10);
 				break;
 				
 			}
 		}
 		
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
 	
 	public void checkoutLandingPage() throws Exception {
     try {
 	    double num=0;
 		loginWithValidData();
 	  // sleep(5);
        cart("MyCart");
        Thread.sleep(35000);
        CheckoutButton("Checkout");
        Thread.sleep(35000);
        
 		
 		
 		List<WebElement> chkamt = getVisibleElementLists(amounts, "CheckoutAmount");
 	     for(WebElement price: chkamt) {
 	    	 
 	    	String Text = price.getText();
			System.out.println("Your Amount will be " + Text);
 			
			
			String sc = Text.replace("$","");
			double ssc=Double.parseDouble(sc);	
			
			Thread.sleep(15000);
			 num = num + ssc;
 		     }
 		
 	    System.out.println("SubTotal after adding shipping :" +num);
 	    String t= Total("Checkout Total");
 	   
        System.out.println("Checkout Total: " + t);
        
        String ogt=t.replace("$", "");
        double ost= Double.parseDouble(ogt);
        Thread.sleep(2000);
        System.out.println("Checkout Total now is: " + ost);
        if (num == ost)
        {
            
           
            System.out.println("Checkout Total is correct");
        }
        else
        {
            System.out.println("Checkout Total not correct");
           Assert.fail("Checkout is incorrect after adding shipping Charges");
        }
 	  }catch(Exception e)
 	  {
 		  Assert.fail("Checkout is incorrect after adding shipping Charges");
 		  
 	  }
 		}

 	
 	 public void RecipientInformation_Verify() throws Exception
	  {  
	 try {	 
		 Recipient("Recipient");
    	if (isDisplayed(ShippingAddress, WAIT_DEFAULT))
    	{
    		System.out.println("Pass: Billing Address is present in RECIPIENT INFORMATION ");
    		BillingAddress("Checkout Total");
    	
    	}
    	else {
    		
    		System.out.println("Fail: Billing Address is Not present in RECIPIENT INFORMATION ");
    		Assert.fail("Fail: Billing Address is Not present in RECIPIENT INFORMATION ");
    	}
	 }catch(Exception e) {
		 
		 Assert.fail("Fail: Billing Address is Not present in RECIPIENT INFORMATION ");
	 }
	 
    }
 
 	 
 	 public void GiftMessage_Text()
 	 {
 		 try {
 			 
 			GiftMessageCheckbox("Message Checkbox");
 			Gift("Sending a Gift,I hope You Like It...");
 			 Recipient("Recipient");
 			 
     if (isDisplayed(cofirmGiftText, WAIT_DEFAULT))
    	{
    		System.out.println("Pass: Gift Message & Delivery date is present in GIFT MESSAGE & DELIVERY DATE ");
    		GiftMessage("Message");
    	 	DeliverydateText("Date of Delivery");
    	}
    	else {
    		
    		System.out.println("Fail: Gift Message & Delivery date is Not present in GIFT MESSAGE & DELIVERY DATE");
    		Assert.fail("Gift Message & Delivery date is Not present in GIFT MESSAGE & DELIVERY DATE ");
    	}
	    }catch(Exception e) {
		 
		 Assert.fail("Fail: Gift Message & Delivery date is Not present in GIFT MESSAGE & DELIVERY DATE");
	 }
 		
 	 }
 	 
 	 public void Billing_Information()
 	 {
 		 try {
 			 
 			 Recipient("Recipient");
     if (isDisplayed(BillingInfo, WAIT_DEFAULT))
    	{
    		System.out.println("Pass: Billing Information is Present ");
    		BillingInformation("BillingText");
    	}
    	else {
    		
    		System.out.println("Fail:Billing Information is Not Present ");
    		Assert.fail("Fail: Billing Information is Not Present");
    	}
	    }catch(Exception e) {
		 
		 Assert.fail("Fail: Billing Information is Not Present");
	 }
 		
 	 }
 	 
 	 
 	 public void CardInformation() {
 		
 		 try {
 		SelectPayment("SelectPayment");
 		System.out.println("*******Selecting the Payment Details******");
 	sleep(15);
 		NameonCC(prop1.getProperty("NameonCreditCard"));
 		CreditCardNumber(prop1.getProperty("cardnumber"));
 		System.out.println("Card Number is entered");
 		
 		Month(prop1.getProperty("expmonth"));
 		System.out.println( "Expiry Month Selected");
 		
 		Year(prop1.getProperty("expyear"));
 		System.out.println("Expiry Year is Entered");
 		
 		CvvNumber(prop1.getProperty("cvv"));
 		
 		
 		 if (isDisplayed(PlaceOrderButton, WAIT_DEFAULT))
     	{
     		System.out.println("Pass: Card Details is filled properly");
     		PlaceOrder("PlaceOrder");
     	}
     	else {
     		
     		System.out.println("Fail:Card Details are not Entered ");
     		Assert.fail("Fail: Card Details are not Entered");
     	}
 	    }catch(Exception e) {
 		 
 		 Assert.fail("Fail: Card Details are not Entered");
 	 }
 	 }
 	 
 	 public void OrderDetails() {
 		 try {
 			OrderText();
 			
 			
 			if(isDisplayed(OrderVerifyText, WAIT_DEFAULT))
 			{
 				String success=Ordernumber();
 	 			System.out.println("Your order number is:" + success);
 				
 			}
 			else
 			{
 				System.out.println("Fail: Sorry your Order is not placed.");
 				Assert.fail("Fail: Sorry your Order is not placed.");
 			}
 		 }catch(Exception e)
 		 {
 			Assert.fail("Fail: Sorry your Order is not placed.");
 			 
 		 }
 			
 			 
 		 }
 		 
 		 
 	 }


