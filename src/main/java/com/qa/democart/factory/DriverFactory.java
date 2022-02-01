package com.qa.democart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author 19163
 *
 */

public class DriverFactory {
	public WebDriver driver;

	/**
	 * @ @param browserName
	 * @return this return WebDriver refrence on the basis of giving
	 */

	public WebDriver init_driver(Properties prop) {
		String browserName =prop.getProperty("browser");
		System.out.println("BrowserName is:  "+browserName);
	
		
		System.out.println("Browser name is :   " + browserName);
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Safari":
			driver = new SafariDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("Please Pass the Correct Browsername:   " + browserName);

			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		return driver;
	}

	/**
	 * This method will initialize the properties from config.properties file
	 */
	public Properties init_prop() {
		Properties prop=null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			 prop = new Properties();
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

}
