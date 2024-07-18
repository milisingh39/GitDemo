package com.tates.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase  extends WebPlatformHandler {

			private int implicitTime = 50;
			private long waitTimeInSecs = 50;

			public void openURL(String URL) throws InterruptedException {
				WebDriver driver = getTargetDriver();
				driver.get(URL);
				
			}
     
			// @BeforeMethod
			public WebElement isElementVisible(By locator, String elementName) {
				WebElement element = null;
				try {
					WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
					element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
				} catch (Exception e) {
					System.out.println("FAIL: " + elementName + " is not visible which is located at " + locator);
				}
				return element;
			}

			// Click the element
			public WebElement click(By locator, String elementName) {
				WebElement element = null;
				try {
					isElementVisible(locator, elementName);
					element = driver.findElement(locator);
					element.click();
					System.out.println("PASS: sucessfully clicked on " + elementName);
				} catch (Exception e) {
					System.out.println("FAIL: To click on " + elementName + "  which is located at " + locator);

				}
				return element;
			}

			// Sendkeys to the element
			public WebElement sendKeys(By locator, String sendkey, String elementName) {
				WebElement element = null;
				try {
					clear(locator, elementName);
					element = driver.findElement(locator);
					element.sendKeys(sendkey);
					System.out.println("PASS: In " + elementName + " sucessfully entered value = " + sendkey);
				} catch (Exception e) {
					System.out.println("FAIL: To send value on " + elementName + "  which is located at " + locator);
				}
				return element;
			}

			// Clear the element
			public boolean clear(By locator, String elementName) {
				boolean isTextCleared = false;
				WebElement element = null;
				try {
					isElementVisible(locator, elementName);
					element = driver.findElement(locator);
					element.clear();
					isTextCleared = true;
					System.out.println("PASS: Cleared text from element " + elementName);
				} catch (Exception e) {
					System.out.println("FAIL: To clear value on " + elementName + "  which is located at " + locator);
				}
				return isTextCleared;
			}

			// Get text of the element
			public String getText(By locator, String elementName) {
				String element = null;
				try {
					isElementVisible(locator, elementName);
					element = driver.findElement(locator).getText();
					System.out.println("PASS: Element text is " + element);
				} catch (Exception e) {
					System.out.println("FAIL: To find the element text" + elementName + "  which is located at " + locator);
				}
				return element;
			}

			// Get classname of the element
			public String getAttribute(WebElement element, String name) {
				return element.getAttribute(name);
			}

			// Implicitly wait
			public void implicitlyWait() {
				driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
			}ju n jui
			
			public void loadPropertiyFile(String fileName) {

				String configFile;

				if (fileName.equalsIgnoreCase("config"))
				configFile = "./src/main/java/com/lg/config/" + fileName + ".properties";
				else
				configFile = "./src/main/java/com/lg/config/" + fileName + ".properties";

				prop = new Properties(System.getProperties());
				try {
				prop.load(new FileReader(configFile));    

				} catch (IOException e) {
				System.out.println("exception occured during load prop file " + e);

				}

				System.setProperties(prop);

				System.out.println("prop file loaded successfully");

				}
			
			protected WebElement mouseHover(By locator, String elementName) {
				WebElement element = null;
				try {
				isElementVisible(locator, elementName);
				element = driver.findElement(locator);
				Actions builder = new Actions(driver);
				builder.moveToElement(element).build().perform();
				System.out.println("PASS: Element drag to " + elementName);
				} catch (Exception e) {
				System.out.println("FAIL: Element to drag to " + elementName);
				}
				return element;
				}
			
				
			protected List<WebElement> getVisibleElementLists(By locator, String elementName) {
				int visibleElementsCount = 0;
				int elementsCount = 0;
				WebDriver driver = getTargetDriver();
				List<WebElement> visibleElementsList = null;
				try {
				WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
				visibleElementsList = wait
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
				// visibleElementsList = driver.findElements(locator);
				visibleElementsCount = visibleElementsList.size();
				System.out.println(
				"Found visibility for list of elements " + elementName + " with size = " + visibleElementsCount);
				} catch (Exception e) {
				try {
				// if all elements are not visible, then get the list of all Elements by Locator
				System.out.println(
				"All elements not visible for " + elementName + " , getting only visible element list...");
				List<WebElement> lstElements = driver.findElements(locator);
				if (lstElements != null && lstElements.size() > 0) {
				visibleElementsList = new ArrayList<WebElement>();
				elementsCount = lstElements.size();
				for (int i = 0; i <= elementsCount; i++) {
				WebElement element = lstElements.get(i);
				if (element.isDisplayed()) {
				visibleElementsList.add(element);
				visibleElementsCount++;
				}
				}
				} else {
				System.out.println(elementName + " web element list is found with size = " + elementsCount
				+ " , Visible elements count =" + visibleElementsCount);
				}
				} catch (Exception e1) {
				String errorMessage = elementName + " web element list is found with size = " + elementsCount
				+ " , Visible elements count =" + visibleElementsCount;
				System.out.println(errorMessage);
				}
				}
				return visibleElementsList;
				}
			
			protected boolean isDisplayed(By locator, long waitTimeInSecs) {
				boolean flag;
				try {
					WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
					driver.findElement(locator).isDisplayed();
					flag = true;
				} catch (Exception e) {
					//System.out.println("Fail to check isDisplayed : " + locator);
					flag = false;
					
				}
				return flag;
			}
			
			

			// Thread.sleep
			public void sleep(int seconds) {
				try {
					int miliseconds = seconds * 1000;
					Thread.sleep(Integer.valueOf(miliseconds));
				} catch (Exception e) {
					System.out.println("Problem Rise During Custom Sleep for the page.....");
				}
			}

			// To encode Credentials
			public String decodetest(String stringtext) {
				byte[] decodedpassword = Base64.decodeBase64(stringtext.getBytes());
				String decodepassword = new String(decodedpassword);
				return decodepassword;
			}
			
			protected boolean isElementVisible(WebElement element, String elementName, long waitTimeInSecs) {
				boolean isElementFound = false;
				WebDriver driver = getDriver();
				try {
				WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
				System.out.println("Waiting " +  " secs for visibility of " + elementName);

				 wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
				System.out.println("Element " + elementName + " is now visible.");
				isElementFound = true;
				} catch (Exception e) {
				System.out.println("Element " + elementName + " is not visible.");
				}
				return isElementFound;
				}
			
			public void Dropdown_Selection_by_Text(By locator, String text) {
				
				WebElement element = driver.findElement(locator);
				Select dropdowntext = new Select(element);
				dropdowntext.selectByVisibleText(text);	
				
			}

		}

 
