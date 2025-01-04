package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC001_LoginTest extends BaseClass{

	@Test
	public void verify_Login() throws InterruptedException {
		//HomePage
		//HomePage hp=new HomePage(driver);
		//hp.clickAdmin();
		//hp.clickSignout();
		
		//LoginPage
		
		logger.info("***Starting login test***");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("admin@pixel.com");
		lp.setPassword("sk12345");
		Thread.sleep(2000);
		logger.info("Clicking on login button");
		lp.clickLogin();
		Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		if(hp.isAdminDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
		
		logger.info("TC001 LoinTest Executed");
		
	}
	
}
