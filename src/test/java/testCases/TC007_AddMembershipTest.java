package testCases;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import pageObjects.AddMembershipPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MembershipPage;
import testBase.BaseClass;

public class TC007_AddMembershipTest extends BaseClass{

@Test
public void verifyAddMembership() {
	logger.info("Started executing");
	LoginPage lp= new LoginPage(driver);
	lp.login("admin@pixel.com", "sk12345");
	//HomePage
	HomePage hp=new HomePage(driver);
	hp.clickMenuTab();
	hp.clickMembershipTab();
	hp.clickMembershipSubTab();
	
	MembershipPage mp=new MembershipPage(driver);
	mp.clickAddMembership();
	
	AddMembershipPage amp=new AddMembershipPage(driver);
	amp.selectMembershipCategory("Standard Membership");
	amp.setMembershipName("Special Pack");
	amp.selectValidityPeriod("One month");
	amp.setMembershipPrice("100");
	amp.clickNext();
	//amp.clickSubmit();
}


}
