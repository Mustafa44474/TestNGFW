package com.qa.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class AccountsPage {
	private ElementUtil elementUtil;
	
	
	private By header =By.cssSelector("div#logo a");
	private By accountSEctionHeaders= By.xpath("//div[@id='content']/h2");
	private By searchText =By.xpath("//input[@name='search']");
	private By searchButton =By.xpath("//span[@class='input-group-btn']");
	private By searchItemResult=By.xpath("//div[@class='product-thumb']");
	
	
	public AccountsPage(WebDriver driver) {
		 elementUtil = new ElementUtil(driver);
		
	}
	
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.Accounts_PAGE_TITLE, 5);
		
	}
	public String getHeaderValue() {
		if(elementUtil.doIsDisplayed(header)) {
		return elementUtil.doGetText(header);
	}
	
		return null;
	}
	public int getAccountSEctionsCount() {
		return   elementUtil.getElements(accountSEctionHeaders).size();
		
	}
	
	public List<String> getAccountSectionsList() {
		List <String > accountList = new ArrayList<String>();
		List <WebElement> accountSesionlist =elementUtil.getElements(accountSEctionHeaders);
		for (WebElement e : accountSesionlist) {
			String secttext =e.getText();
			System.out.println(secttext);
			accountList.add(secttext);
		}
		return accountList;
	}
	

	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if(elementUtil.getElements(searchItemResult).size()>0){
			return true;
		}
			
		return false;
	 
	
	
	
}
	

}
