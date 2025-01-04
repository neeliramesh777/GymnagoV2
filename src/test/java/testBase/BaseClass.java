package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public Logger logger;
	
	public WebDriver driver;
	
	@Parameters({"os", "browser"})
	@BeforeClass
public void setup(String os, String br) throws IOException{
		
		//Loading config.properties file
		
		//FileReader file= new FileReader("./src//test//resources//config.properties");
		//p=new Properties();
		//p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		//System.setProperty("webdriver.chrome.driver", "chromedriver11.exe");
		switch (br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();
			break;
		case "edge": driver=new EdgeDriver();
		break;
		case "firefox": driver=new FirefoxDriver();
		break;
		default: System.out.println("Invalid browser name..");
			return;
		}
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://gymnago.com:8000/");//Reading url from properties file.
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();}}
	
	public String RandomString() {
		// TODO Auto-generated method stub
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String RandomNumber() {
		
		String generatednumber=RandomStringUtils.randomNumeric(8);
		return generatednumber;
		
	}
	
	public String RandomAlphaNumberic() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return(generatedstring+"@"+generatednumber);
	}
}
