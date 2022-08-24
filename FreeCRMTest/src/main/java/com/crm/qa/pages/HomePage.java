package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//*[@class='headertext' and @align='left']")
	WebElement userNameLable;
	
	@FindBy(xpath = "//*[text()='Contacts']")
	WebElement contactlLink;
	
	@FindBy(xpath = "//*[text()='Deals']")
	WebElement dealslLink;
	
	@FindBy(xpath = "//*[text()='Tasks']")
	WebElement taskslLink;
	
	@FindBy(xpath = "//*[text()='New Contact']")
	WebElement newContactLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactLink() {
		contactlLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealslLink.click();
		return new DealsPage();
	}
	
	public boolean verifyUsername() {
		return userNameLable.isDisplayed();
	}
	
	public void clickOnNewContactsLink() {
//		Actions action = new Actions(driver);
//		System.err.println("Iam in clickNewContactsLink in");
//		action.moveToElement(contactlLink).build().perform();
//		System.err.println("Iam in clickNewContactsLink middle");
//		newContactLink.click();
//		System.err.println("Iam in clickNewContactsLink out");
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", newContactLink);
	}
	
	
}
