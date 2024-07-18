package com.tates.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebPlatformHandler {

	public static WebDriver driver;

	protected static Logger logger;

	public static Properties prop;

	public static Properties prop1;

	public static Properties prop2;

	private ChromeOptions chromeOptions = new ChromeOptions();

	private FirefoxOptions firefoxOptions = new FirefoxOptions();

	public WebPlatformHandler() {

		// Initializing the prop variable to read the files from config.properties
		try {

			prop = new Properties();
			FileInputStream browser = new FileInputStream("./src/main/java/com/tates/config/driver.properties");
			prop.load(browser);

			prop1 = new Properties();
			FileInputStream userdata = new FileInputStream("./src/main/java/com/tates/config/config.properties");
			prop1.load(userdata);

			prop2 = new Properties();
			FileInputStream logindata = new FileInputStream("./src/main/java/com/tates/config/login.properties");
			prop2.load(logindata);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void createDriver() {
		if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));

			chromeOptions.addArguments("--disable-notifications");

			driver = new ChromeDriver(chromeOptions);

		} else if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("mozillaDriverPath"));

			firefoxOptions.addArguments("--disable-notifications");

			driver = new FirefoxDriver(firefoxOptions);
		} else if (prop.getProperty("browserName").equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", prop.getProperty("IEDriverPath"));

			driver = new InternetExplorerDriver();

		} else {
			System.out.println("No Matching browser found for  " + prop.getProperty("browserName"));
			// tearDown();
		}

		driver.manage().window().maximize();

		// Open URL

		WebDriver driver = getTargetDriver();
		driver.get(prop.getProperty("URL"));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver getTargetDriver() {
		if (driver == null) {
			String message = "Driver is null, cannot continue. Application has probably crashed or Driver creation failed!";
			System.out.println(message);
		}
		//PageFactory.initElements(driver, this);
		return driver;
	}

	@AfterClass
	public void tearDown() {
		WebDriver driver = getTargetDriver();
	  	driver.close();
      driver.quit();
	}

}


