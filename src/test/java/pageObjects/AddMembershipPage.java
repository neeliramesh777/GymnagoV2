package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMembershipPage extends BasePage{

	public AddMembershipPage(WebDriver driver) {
		super(driver);
	
	}

@FindBy(xpath = "//body/div[@id='root']/div[@class='d-flex vh-100 overflow-hidden w-100']/section[@class='main-page pageBg flex-grow-0 flex-shrink-0 notFullWided']/main[@class='mainPage']/div[@class='container-fluid']/div[@class='row px-3']/div[@class='col-12 br-15px pageInnerBg']/div[@class='row']/div[@class='col-12']/div[@class='tab-content']/div[@id='menu0']/form[@class='row']/div[2]/div[2]/div[1]")
WebElement divMembersipCategory;

@FindBy(xpath = "//input[@name='memberShipName']")
WebElement txtMembershipName;

@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/form[1]/div[6]/div[2]/div[1]")
WebElement divValidityPeriod;

@FindBy(xpath = "//*[@name='memberShipPrice']")
WebElement txtMembershipPrice;
@FindBy(linkText = "Submit")
WebElement btnSubmit;

@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary Mui-focused MuiInputBase-formControl custom-multiselect css-79r2em']//div[@role='button']")
WebElement divGender;

@FindBy(linkText = "Next")
WebElement btnNext;


public void selectMembershipCategory(String category) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(divMembersipCategory));
	
	divMembersipCategory.click();
	WebElement category1=driver.findElement(By.xpath("//ul/li/span[contains(text(), '"+category+"')]"));
	category1.click();
}

public void setMembershipName(String membershipname) {
	txtMembershipName.sendKeys(membershipname);
}

public void selectValidityPeriod(String period) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(divValidityPeriod));
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", divValidityPeriod);
	
	divValidityPeriod.click();
	WebElement period1=driver.findElement(By.xpath("//ul/li/span[contains(text(), '"+period+"')]"));
	period1.click();
}

public void setMembershipPrice(String price) {
	txtMembershipPrice.sendKeys(price);
}


public void selectGender(String gender) {
	divGender.click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//ul/li/div/span[contains(text(), "+gender+")]")));
	
	WebElement gender1=driver.findElement(By.xpath("//ul/li/div/span[contains(text(), "+gender+")]"));
	gender1.click();
	
}

public void clickNext() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", btnNext);
	
	btnNext.click();
}

public void clickSubmit() {
	btnSubmit.click();
}
	
}
