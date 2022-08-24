package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializer();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		AssertJUnit.assertEquals(homePageTitle, "CRMPRO","Home Page Title not matched.");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.swithToFrame("mainpanel");
		AssertJUnit.assertTrue(homePage.verifyUsername());
	}
	
	@Test(priority = 3)
	public void verifyContactsLink() {
		testUtil.swithToFrame("mainpanel");
		contactsPage = homePage.clickOnContactLink();
	}
	
	@Test(priority = 4)
	public void verifyDealsLink() {
		testUtil.swithToFrame("mainpanel");
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
