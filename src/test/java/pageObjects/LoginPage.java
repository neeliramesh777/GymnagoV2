package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='LOGIN']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//span[@class='text-dark position-relative fw-bold']")
	WebElement toastermsg;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void login(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public boolean isMsgDisplayed() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(toastermsg));
		boolean errormsg=toastermsg.isDisplayed();
		return errormsg;
	}
}
