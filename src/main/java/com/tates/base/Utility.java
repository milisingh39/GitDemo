package com.tates.base;

import org.testng.Assert;


public class Utility extends TestBase {
		
		public void Verify_Page_Title(String actualPageTitle, String expectedPageTitle, String pageName)
				throws InterruptedException {
			try {
				if (actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {
					System.out.println("PASSED : " + pageName + " Title Verified");
				} else {
					System.out.println("ELSE Failed : " + pageName + " Title Not Verified");
					System.out.println("Actual Page Title is " + actualPageTitle);
					System.out.println("Expected Page Title is " + expectedPageTitle);
					Assert.fail("ELSE FAILED : " + pageName + " Title Not Verified");
				}

			} catch (Exception e) {
				System.out.println(e);
				System.out.println("CATCH FAILED : " + pageName + " Title Not Verified");
				Assert.fail("CATCH FAILED : " + pageName + " Title Not Verified");
			}
		}
		
		
		
	}

	
