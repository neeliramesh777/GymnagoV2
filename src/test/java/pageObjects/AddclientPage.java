package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddclientPage extends BasePage{

	public AddclientPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

@FindBy(name ="firstName")
WebElement txtFirstname;

@FindBy(name ="lastName")
WebElement txtLastname;

@FindBy(name ="email")
WebElement txtEmail;

@FindBy(name = "mobileNo")
WebElement txtMobile;

@FindBy(xpath = "//button[@aria-label='Choose date, selected date is Nov 13, 2024']")
WebElement btnDateofBirth;

@FindBy(name = "emergencyNumber")
WebElement txtEmergencyNo;

@FindBy(xpath  = "//button[normalize-space()='Accept Terms & Condition']")
WebElement btnAcceptTandC;

@FindBy(partialLinkText = "Standard Si")
WebElement btnSigntab;

@FindBy(xpath = "//*[@id=\"signature-pad\"]/canvas")
WebElement Sign;

@FindBy(xpath = "//div[contains(@class,'modal-header border-bottom text-center')]//button[contains(@type,'button')]")
WebElement btnClose;

@FindBy(xpath = "//button[normalize-space()='Submit']")
WebElement btnSubmit;

@FindBy(xpath = "//h5[normalize-space()='Account Successfully Created']")
WebElement divAccountCreated;


public void setFirstname(String firstname) {
		txtFirstname.sendKeys(firstname);
  }

public void setLastname(String lastname) {
	txtLastname.sendKeys(lastname);
}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setMobileNumber(String mobilenumber) {
	txtMobile.sendKeys(mobilenumber);
}

public void setEmergencyNumber(String emergencyNymber) {
	txtEmergencyNo.sendKeys(emergencyNymber);
}

public void clickTermsAndConditions() {
	btnAcceptTandC.click();
}

public void clickSigntab() {
	btnSigntab.click();
}

public void clickCloseTandC(){
	btnClose.click();
}

public void clickSubmit() {
	btnSubmit.click();
}

public boolean conifrmationmsg() {
	return divAccountCreated.isDisplayed();
}

}
