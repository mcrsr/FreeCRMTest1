package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPgae;
	TestUtil testUtil;
	ContactsPage contactsPage;
	HomePage homePage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializer();
		testUtil = new TestUtil();
		loginPgae = new LoginPage();
		homePage = loginPgae.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame("mainpanel");
		contactsPage = homePage.clickOnContactLink();
	}
	
	
	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		AssertJUnit.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Parameters({"contactName"})
	@Test(priority = 2)
	public void selectContctTest(@Optional("Tom Petet") String contactName) {
		contactsPage.selectContct(contactName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Parameters({"contactName1","contactName2"})
	@Test(priority = 3)
	public void selectMultipleContctsTest(@Optional("john Kenedy") String contactName1,@Optional("JOhny Depp") String contactName2) {
		contactsPage.selectContct(contactName1);
		contactsPage.selectContct(contactName2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] generateTestData(){
		
		return new Object[][] {
			{"Dr.","david","Cris","Amazon"},
			{"Mrs.","Mukta","Sharma","Ebay"},
			{"Mr.","david","Sharma","Google"}
		};
		
		
	}
	
	@Test(priority = 4,dataProvider = "generateTestData")
	public void createNewContact(String title,String firstName,String lastName,String company) {
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
