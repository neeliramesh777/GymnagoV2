package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends BasePage{

	public MembershipPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath = "//button[normalize-space()='Add new Membership']")	
WebElement btnAddMembership;







public void clickAddMembership() {
	btnAddMembership.click();
}


	
}
