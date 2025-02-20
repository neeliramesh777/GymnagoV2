package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditClientPage extends BasePage{

	public EditClientPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
@FindBy(xpath="//button[normalize-space()='Submit']")
WebElement btnSubmit;

@FindBy(linkText = "Cancel")
WebElement btnCancel;

@FindBy(xpath="//*[contains(text(),\"successfully updated Client !!\")]")
WebElement toasterMsg;


public void clickSubmit() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
	btnSubmit.click();
}

public void clickCancel() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(btnCancel));
	btnCancel.click();
}

public boolean isMsgDisplayed() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(toasterMsg));
	boolean status=toasterMsg.isDisplayed();
	return status;
}

	
}
