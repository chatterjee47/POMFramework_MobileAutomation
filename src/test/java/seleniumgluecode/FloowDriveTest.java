package seleniumgluecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.MobileConfiguration;
import PageObjectRepository.FloowDrive;

import Utility.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FloowDriveTest {

	FloowDrive loginpage;
	public static AndroidDriver<AndroidElement> driver;
	String filepath = System.getProperty("user.dir") + "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	static String expectedmessage;
	static String actualmessage;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void SetExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//extendedreport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Amit Chatterjee");
		extent.setSystemInfo("Browser Name", "Chrome");
	}

	// step3
	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeMethod
	public void HomePageNavigation() throws Throwable {
		fileInput = new FileInputStream(filepath);
		prop = new Properties();
		prop.load(fileInput);

		driver = MobileConfiguration.MobileSetUp(prop.getProperty("deviceName"), prop.getProperty("platformVersion"),
				prop.getProperty("platformName"), prop.getProperty("apkPackage"), prop.getProperty("apkActivity"));
		System.out.println("Floow Drive app is opened successfully");
	}

	@Test(priority = 0, enabled = true)
	public void FloowDriveFunctionality() throws Exception {
		Thread.sleep(10000);
		test = extent.createTest("FloowDriveFunctionality");
		Utilities ut = new Utilities(driver);
		ut.scrollToText("Already registered");
		Thread.sleep(10000);
		loginpage = new FloowDrive(driver);
		loginpage.btn_already_registered();
		Thread.sleep(10000);
		loginpage.ForGotPassword();
		Thread.sleep(10000);
		loginpage.EmailAddress("ssl-27@hotmail.com");
		loginpage.SendButton();
		Thread.sleep(10000);
		expectedmessage = loginpage.Resetpassword();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Reset password";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.BackButton();
		Thread.sleep(5000);
		loginpage.BackButton();
		Thread.sleep(5000);
		loginpage.EmailAddress("ssl-27@hotmail.com");
		Thread.sleep(5000);
		loginpage.Password("Efgh123456");
		Thread.sleep(5000);
		loginpage.LoginButton();
		Thread.sleep(10000);
		expectedmessage = loginpage.ErrorMessage();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Could not log in";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		System.out.println("Passed Successfully");
		Thread.sleep(5000);
		loginpage.OKButton();
		Thread.sleep(5000);
		loginpage.BackButton();
		Thread.sleep(5000);
		ut.scrollToText("Already registered");
		Thread.sleep(5000);
		loginpage = new FloowDrive(driver);
		loginpage.btn_already_registered();
		Thread.sleep(5000);
		loginpage.EmailAddress("chatterjeeamit41@gmail.com");
		Thread.sleep(5000);
		loginpage.Password("Testing123$");
		Thread.sleep(5000);
		loginpage.LoginButton();
		Thread.sleep(10000);
		loginpage.AllowAllTheTime();
		Thread.sleep(5000);
		loginpage.Whileusingtheapp();
		Thread.sleep(5000);
		loginpage.AllowBtn();
		Thread.sleep(5000);
		loginpage.permission_allow_button();
		Thread.sleep(5000);
		expectedmessage = loginpage.stationary();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Stationary";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.btn_dashboard_pause();
		Thread.sleep(1000);
		ut.SeekBarTest();
		Thread.sleep(1000);
		loginpage.CanceButton();
		Thread.sleep(1000);
		expectedmessage = loginpage.AutoRecordingPaused();
		System.out.println("expected message : " + expectedmessage);

		Thread.sleep(10000);
		loginpage.Journeystab();
		Thread.sleep(10000);
		expectedmessage = loginpage.TodayDayDateMonthMessage();
		System.out.println("expected message : " + expectedmessage);
		Thread.sleep(1000);
		loginpage.Journeystab();
		Thread.sleep(1000);
		loginpage.TodayDayDateMonthMessge();
		Thread.sleep(1000);
		expectedmessage = loginpage.RecordingPause();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Recording paused";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);
		loginpage.CloseButton();
		Thread.sleep(1000);
		expectedmessage = loginpage.YourTrips();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Your trips";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);
		Thread.sleep(5000);
		loginpage.HomeTab();
		Thread.sleep(1000);
		loginpage.btn_dashboard_pause();
		Thread.sleep(1000);
		loginpage.RestartRecording();
		Thread.sleep(1000);
		loginpage.CanceButton();
		Thread.sleep(5000);
		expectedmessage = loginpage.stationary();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Stationary";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(5000);
		expectedmessage = loginpage.Score();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Score";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.ScoreNextButton();
		Thread.sleep(5000);
		expectedmessage = loginpage.SmoothDriving();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Smooth Driving";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.ScoreNextButton();
		Thread.sleep(5000);
		expectedmessage = loginpage.MobileUse();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Mobile Use";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.ScoreNextButton();
		Thread.sleep(5000);
		expectedmessage = loginpage.Speed();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Speed";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.ScoreNextButton();
		Thread.sleep(5000);
		expectedmessage = loginpage.Fatigue();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Fatigue";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(10000);
		loginpage.ScoreNextButton();
		Thread.sleep(5000);
		expectedmessage = loginpage.TimeofDay();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Time of Day";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);
		loginpage.ScorePreviousButton();
		Thread.sleep(1000);
		loginpage.ScorePreviousButton();
		Thread.sleep(1000);
		loginpage.ScorePreviousButton();
		Thread.sleep(1000);
		loginpage.ScorePreviousButton();
		Thread.sleep(1000);
		loginpage.ScorePreviousButton();
		Thread.sleep(1000);
		expectedmessage = loginpage.Score();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Score";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);
		loginpage.MoreButton();
		Thread.sleep(1000);
		loginpage.Preferences();
		Thread.sleep(1000);
		loginpage.CheckBox();
		Thread.sleep(1000);
		loginpage.CheckBox();
		Thread.sleep(1000);
		loginpage.fifteenpercentage();
		Thread.sleep(1000);
		loginpage.twentypercentage();
		Thread.sleep(1000);
		loginpage.twentyfivepercentage();
		Thread.sleep(1000);
		loginpage.thirtypercentage();
		Thread.sleep(1000);
		loginpage.auto();
		Thread.sleep(1000);
		loginpage.imperial();
		Thread.sleep(1000);
		loginpage.metric();
		Thread.sleep(1000);
		loginpage.CheckBox2();
		Thread.sleep(1000);
		loginpage.CheckBox2();
		Thread.sleep(1000);
		loginpage.BackButtonPreference();
		Thread.sleep(1000);
		expectedmessage = loginpage.PreferencesText();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "Preferences";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);
		Thread.sleep(1000);
		expectedmessage = loginpage.MoreDisplay();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "More";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);
		loginpage.FAQs();
		Thread.sleep(1000);
		loginpage.Journeyrecording();
		Thread.sleep(5000);
		loginpage.automaticjourneyrecording();
		Thread.sleep(5000);
		loginpage.BackButtonPreference();
		Thread.sleep(5000);
		loginpage.BackButtonPreference();
		Thread.sleep(5000);

		expectedmessage = loginpage.MoreDisplay();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "More";
		Assert.assertEquals(actualmessage, expectedmessage);

		Thread.sleep(1000);
		loginpage.TermsandConditions();
		Thread.sleep(10000);
		ut.scrollTillEnd();
		Thread.sleep(10000);
		loginpage.BackButtonPreference();
		Thread.sleep(1000);
		expectedmessage = loginpage.MoreDisplay();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "More";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);

		loginpage.OptimizationsButton();
		Thread.sleep(1000);
		loginpage.AddaptiveBattery();
		Thread.sleep(1000);
		loginpage.AddaptiveBatterynextBtn();
		Thread.sleep(1000);
		loginpage.BackButtonPreference();
		Thread.sleep(1000);
		loginpage.BackButtonPreference();
		Thread.sleep(1000);
		expectedmessage = loginpage.MoreDisplay();
		System.out.println("expected message : " + expectedmessage);
		actualmessage = "More";
		Assert.assertEquals(actualmessage, expectedmessage);
		Thread.sleep(1000);

		loginpage.Changepassword();
		Thread.sleep(1000);
		loginpage.Currentpasswordsign();
		Thread.sleep(1000);
		loginpage.Newpasswordsign();
		Thread.sleep(1000);
		loginpage.CurrentpasswordTextbox("Testing123$");
		Thread.sleep(1000);
		loginpage.NewpasswordTextbox("Testing123$");
		Thread.sleep(1000);
		loginpage.RepeatpasswordTextbox("Testing123$");
		Thread.sleep(1000);
		loginpage.CurrentpasswordShow();
		Thread.sleep(1000);
		loginpage.NewpasswordShow();
		Thread.sleep(10000);
		loginpage.ChangeIt();
		Thread.sleep(10000);
		loginpage.About();
		Thread.sleep(5000);
		loginpage.Logout();
		Thread.sleep(5000);
		loginpage.LogoutOk();
		Thread.sleep(1000);

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); 
			String screenshotPath = FloowDriveTest.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.closeApp();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
