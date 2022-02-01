package com.qa.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class LoginPage {
	 
	private ElementUtil elementUtil;
	// Page locator
	private By emailId = By.id("input-email");
	private By pwd1 = By.id("input-password");
	private By LoginBTN = By.xpath("//input[@value='Login']");
	private By fogotPWD = By.linkText("Forgotten Password");

	public LoginPage(WebDriver driver) {
		 
		elementUtil = new ElementUtil(driver);

	}

	// page Action
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.LOGIN_PAGE_TITLE,3);

	}

	public boolean isForgoPWSLinkExist() {
		if(elementUtil.getElements(fogotPWD).size()==Constants.forgotLink)
			return true;
			return false;
	}

	public void doLogin(String un, String pwd) {
		System.out.println("Login with Username:   " + un + "and Password:  " + pwd);
//		driver.findElement(emailId).sendKeys("gmustafasiddiqi10@gmail.com");
//		driver.findElement(pwd1).sendKeys("Test@321");
//		driver.findElement(LoginBTN).click();

		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(pwd1, pwd);
		elementUtil.doClick(LoginBTN);
	}

}
