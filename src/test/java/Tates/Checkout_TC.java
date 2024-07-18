package Tates;

import org.testng.annotations.Test;

import com.tates.base.TestBase;
import com.tates.pages.CheckoutPage;

public class Checkout_TC extends TestBase{
	
	CheckoutPage ck= new CheckoutPage();
	
	
	@Test(priority=1, enabled=true)
	public void VerifyCheckoutPage() throws Exception
	{
	System.out.println("********************Verifying the Calculations in Checkout Page********************");
		ck.checkoutLandingPage();
		
	}
	@Test(priority=2, enabled=true)
	public void VerifyBillingAddress() throws Exception {
	System.out.println("********************Verifying the Receipient Information********************");
	 // ck.AllSections();
	  ck.RecipientInformation_Verify();
	
	}
	
	@Test(priority=3, enabled=true)
	public void VerifyGiftMessageandDeliveryDate() throws Exception {
	System.out.println("********************Verifying the Gift Message & Delivery Date Information********************");
	  ck.GiftMessage_Text();
	
	}
	
	@Test(priority=4, enabled=true)
	public void VerifyBillingInformation() throws Exception {
	System.out.println("********************Verifying the Billing Information********************");
	  ck.Billing_Information();
	
	}
	@Test(priority=5, enabled=true)
	public void VerifyCardInformation() throws Exception {
	System.out.println("********************Verifying the Card Details Entered********************");
	  ck.CardInformation();
	
	}
	
	@Test(priority=6, enabled=true)
	public void VerifyOrderSucess() throws Exception {
	System.out.println("********************Verifying the Order Confirmation********************");
	  ck.OrderDetails();
	
	}
}
