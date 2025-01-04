package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC006_LoginWithInvalid extends BaseClass{


	@Test
	public void verifyLoginWithInvalid() {
		logger.info("***Starting login test***");
		LoginPage lp=new LoginPage(driver);
		lp.login("admin@gmail.com", "12345");
		
		Boolean status=lp.isMsgDisplayed();
			
		Assert.assertTrue(status);
	}
	
	
}
