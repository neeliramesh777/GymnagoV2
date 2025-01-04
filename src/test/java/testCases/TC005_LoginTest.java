package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;




public class TC005_LoginTest extends BaseClass{
	
	
	
	
	@Test
	public void verifyLoginWithValid() {
		logger.info("***Starting login test***");
		LoginPage lp=new LoginPage(driver);
		lp.login("admin@pixel.com", "sk12345");
		
		HomePage hp=new HomePage(driver);
			Boolean Status=hp.isAdminDisplayed();
			
		Assert.assertTrue(Status);
	}
	

	
}
