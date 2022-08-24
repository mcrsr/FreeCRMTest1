package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage  extends TestBase{

	@FindBy(xpath = "//*[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	// //input[@type='checkbox' and @name='contact_id']
	@FindBy(xpath = "//a[contains(text(),'John Cena')]/parent::td/preceding-sibling::td")
	WebElement contactsCheckBox;
	
	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//form[@id='contactForm']//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLable.isDisplayed();
	}
	
	public void selectContct(String name) {
		driver.findElement(By.xpath("//a[contains(text(),"+name+")]/parent::td/preceding-sibling::td")).click();
	}
	
	public void createNewContact(String title,String firstName,String lastName,String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.company.sendKeys(company);
			
		saveBtn.click();
	}
	
}
