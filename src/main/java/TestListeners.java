package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListeners implements ITestListener {

	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
//	Base base = new Base();

	public void onFinish(ITestContext context) {
		System.out.println("On Finish");
		reports.endTest(test);
		reports.flush();
	}

	public void onStart(ITestContext context) {
		System.out.println("On Start");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Test success within percentage");
	}

	
	
	public void onTestFailure(ITestResult result) {
		 WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver"); 
		if(ITestResult.FAILURE==result.getStatus()){
		System.out.println("On Test Failure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test is Failed");
		TakesScreenshot scrShot  = (TakesScreenshot) driver;
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//ScreenshotFiles"
					+ result.getMethod().getMethodName() + ".png"));
			String file = test.addScreenCapture(
					System.getProperty("user.dir") + "//ScreenshotFiles" + result.getMethod().getMethodName() + ".png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test is Failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test is Failed",
					result.getThrowable().getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "Test is Skipped");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "Test is Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "Test is Passed");
	}

}
