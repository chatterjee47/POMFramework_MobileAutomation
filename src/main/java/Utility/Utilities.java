package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	
	AndroidDriver<AndroidElement>  driver;

	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	
	public void SeekBarTest(){
		WebElement slider=driver.findElement(By.xpath("//android.widget.SeekBar[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/pause_slider']"));
		// get start co-ordinate of seekbar
		int start=slider.getLocation().getX();
		//Get width of seekbar
		int end=slider.getSize().getWidth();
		//get location of seekbar vertically
		int y=slider.getLocation().getY();

		    // Select till which position you want to move the seekbar
		    TouchAction action=new TouchAction(driver);

		   
		    //Move it 40%
		    int moveTo=(int)(end*0.4);
		    action.press(start,y).moveTo(moveTo,y).release().perform();
		}
	
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void scrollTillEnd()
	{
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		System.out.println("s="+scrollStart);
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		for (int i = 0; i < dimensions.getHeight(); i++) 
		{
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='Optimizations']")).size()>0)
			break;
		}
	}
	
	public void scrollToWebElement(WebElement element){
	//	WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
