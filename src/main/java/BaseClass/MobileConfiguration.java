package BaseClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileConfiguration {

	static AndroidDriver<AndroidElement> driver;
	private static String sdkPath = "C:/Users/Rush 14/AppData/Local/Android/Sdk/";
	private static String emulatorPath = sdkPath + "tools" + File.separator + "emulator";
	static File source;

	public void startAppiumServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(
					"cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			Thread.sleep(10000);
			System.out.println("Appium launched Successfully!");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopAppiumServer() throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
			Thread.sleep(10000);
			System.out.println("Appium Stopped Successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchEmulator(String nameOfAVD) {
		System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
		String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
		try {
			new ProcessBuilder(aCommand).start();
			Thread.sleep(10000);
			System.out.println("Emulator launched successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeEmulator(String nameOfAVD) {
		System.out.println("Killing emulator for '" + nameOfAVD + "' ...");
		String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD, "emu", "kill" };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(1, TimeUnit.SECONDS);
			System.out.println("Emulator closed successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AndroidDriver<AndroidElement> MobileSetUp(

			String deviceName, String platformVersion, String platformName, String apkPackage, String apkActivity)
			throws Exception {
		File filePath = new File(System.getProperty("user.dir"));
		File appDir = new File(filePath, "/app");
		File app = new File(appDir, "Turnkey_ceeaa872-7331-4190-bccd-111cd935e23e.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apkPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, apkActivity);
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		Thread.sleep(10000);
		System.out.println("Connected to Mobile Successfully");
		return driver;
	}

	public void failed()
	{
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(srcFile, new File("/CucumberSelenium/Screenshots"
	+ "ScreenshotsTaken/tests.jpg"));
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	 
	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "//Screenshots//" + s + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
