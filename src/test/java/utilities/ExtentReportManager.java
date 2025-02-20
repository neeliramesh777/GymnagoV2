package utilities;

import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{

	public ExtentSparkReporter sparkReporter;  //UI of the report
	public ExtentReports extent;  //populate common info on the report 
	public ExtentTest test;  //creating test case entries in the report and update of the test methods
	
	String repName;
	
	public void onStart(ITestContext context) {
		
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);*/
		
		
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		
		sparkReporter.config().setDocumentTitle("gymnagoV2 Automation Report");
		sparkReporter.config().setReportName("gymnagoV2 Funtional Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "gymnagoV2");
		extent.setSystemInfo("Module", "Clients");
		extent.setSystemInfo("Sub Module", "Clients");
		extent.setSystemInfo("User Name", "Customers");
		extent.setSystemInfo("Environment", "QA");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS,result.getName()+" got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL,result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (IOException e1) {
			e1.printStackTrace();// TODO: handle exception
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got sckipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		/*String pathOfExtentReport = System.getProperty(".\\reports\\" + repName);
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		
		}catch (IOException e) {
			e.printStackTrace();
		}*/
		
		 /*try {
			 URL url = new URL("file:///"+System.getProperty(".\\reports\\" + repName));
			 
			 //Create the email message
			 ImageHtmlEmail email = new ImageHtmlEmail();
			 email.setDataSourceResolver(new DataSourceUrlResolver(url));
			 email.setHostName("smtp.googleemail.com");
			 email.setSmtpPort(465);
			 email.setAuthenticator(new DefaultAuthenticator("neeliramesh777@gmail.com", "password"));
			 email.setSSLOnConnect(true);
			 email.setFrom("neeliramesh777@gmail.com");//Sender
			 email.setSubject("Test Result");
			 email.setMsg("Please find Attatched Report...");
			 email.addTo("neeliramesh299@gmail.com");//Receiver
			 email.attach(url, "extent report", "please check report...");
			 email.send(); //send the email;
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		*/
	}
	
}
