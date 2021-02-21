package PageObjectRepository;


import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class FloowDrive {
	
	WebDriver driver;
	public static AndroidDriver<AndroidElement> Mobiledriver;
	public FloowDrive(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_already_registered']")
	private WebElement btn_already_registered;

	public void btn_already_registered() {
		btn_already_registered.click();		
	}

	@FindBy(xpath = "//android.widget.Button[@text='Already registered']")
	private WebElement AlreadyRegistered;

	public WebElement AlreadyRegistered() {
		return AlreadyRegistered;
	}

	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_forgot_password']")
	private WebElement ForGotPassword;

	public void ForGotPassword() {
		ForGotPassword.click();
	}

	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/email_input']")
	private WebElement EmailAddress;
	
	public void EmailAddress(String value) {
		EmailAddress.clear();
		EmailAddress.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input'])[1]")
	private WebElement Password;
	
	public void Password(String value) {
		Password.clear();
		Password.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input'])[2]")
	private WebElement RepeatPassword;
	
	public void RepeatPassword(String value) {
		RepeatPassword.clear();
		RepeatPassword.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/name_input'])[1]")
	private WebElement FirstName;
	
	public void FirstName(String value) {
		FirstName.clear();
		FirstName.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/name_input'])[2]")
	private WebElement LastName;
	
	public void LastName(String value) {
		LastName.clear();
		LastName.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input'])[3]")
	private WebElement PostalCode;
	
	public void PostalCode(String value) {
		PostalCode.clear();
		PostalCode.sendKeys(value);
	}
	
	@FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/chk_agree']")
	private WebElement TermsAgreement;

	public void TermsAgreement() {
		TermsAgreement.click();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_register']")
	private WebElement RegisterButton;

	public void RegisterButton() {
		RegisterButton.click();
	}
	
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_login']")
	private WebElement LoginButton;

	public void LoginButton() {
		LoginButton.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Could not log in']")
	private WebElement ErrorMessage;

	public String ErrorMessage() {
		return ErrorMessage.getText();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/fat_button_1']")
	private WebElement OKButton;

	public void OKButton() {
		OKButton.click();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_get_code']")
	private WebElement SendButton;

	public void SendButton() {
		SendButton.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Reset password']")
	private WebElement Resetpassword;

	public String Resetpassword() {
		return Resetpassword.getText();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
	public List<WebElement> ProductDetails;
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/branding_back']")
	private WebElement BackButton;

	public void BackButton() {
		BackButton.click();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_button']")
	private WebElement AllowAllTheTime;

	public void AllowAllTheTime() {
		AllowAllTheTime.click();		
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_no_upgrade_and_dont_ask_again_button']")
	private WebElement dont_ask_again_button;

	public void dont_ask_again_button() {
		dont_ask_again_button.click();		
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_dashboard_pause']")
	private WebElement btn_dashboard_pause;

	public void btn_dashboard_pause() {
		btn_dashboard_pause.click();		
	}
	
	@FindBy(xpath = "//android.widget.SeekBar[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/pause_slider']")
	private WebElement SeekBar;

	public WebElement SeekBar() {
		return SeekBar;
	}
	
	
	
	@FindBy(xpath = "//android.widget.TextView[@text='Stationary']")
	private WebElement stationary;

	public String stationary() {
		return stationary.getText();
	}
	
	
	public void MoveSlider(WebElement element){
		
	    Actions move = new Actions(driver);
	    Action action = (Action) move.dragAndDropBy(element, 10, 0).build();
	    ((Actions) action).perform();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
	private WebElement Whileusingtheapp;

	public void Whileusingtheapp() {
		Whileusingtheapp.click();		
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_button']")
	private WebElement AllowBtn;
	
	public void AllowBtn() {
		AllowBtn.click();		
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	private WebElement permission_allow_button;
	
	public void permission_allow_button() {
		permission_allow_button.click();		
	}
	
	
	/*Scenario Auto recording message in journeys page -
	Given that auto recording pause session is at process
	When I press Journeys tab
	Then I shall be able to see the message that I have today paused an auto record session with the
	     format "Today, Day, Date Month"*/
	     
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='JourneyList']")
	private WebElement Journeystab;
	
	public void Journeystab() {
		Journeystab.click();		
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/day_text']")
	private WebElement TodayDayDateMonthMessage;
	
	public void TodayDayDateMonthMessge() {
		TodayDayDateMonthMessage.click();		
	}

	public String TodayDayDateMonthMessage() {
		return TodayDayDateMonthMessage.getText();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/pause_details_title']")
	private WebElement RecordingPause;

	public String RecordingPause() {
		return RecordingPause.getText();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/fat_button_1']")
	private WebElement CloseButton;
	
	public void CloseButton() {
		CloseButton.click();		
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/navigation_title']")
	private WebElement YourTrips;

	public String YourTrips() {
		return YourTrips.getText();
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_close_pause_layout']")
	private WebElement CanceButton;

	public void CanceButton() {
		CanceButton.click();		
	}
	
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_clear_pause']")
	private WebElement RestartRecording;

	public void RestartRecording() {
		RestartRecording.click();		
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/manual_pause_countdown']")
	private WebElement AutoRecordingPaused;

	public String AutoRecordingPaused() {
		return AutoRecordingPaused.getText();
	}
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Dashboard']")
	private WebElement HomeTab;
	
	public void HomeTab() {
		HomeTab.click();		
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/score_title']")
	private WebElement Score;

	public String Score() {
		return Score.getText();
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_next']")
	private WebElement ScoreNextButton;

	public void ScoreNextButton() {
		ScoreNextButton.click();
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_prev']")
	private WebElement ScorePreviousButton;

	public void ScorePreviousButton() {
		ScorePreviousButton.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Smooth Driving']")
	private WebElement SmoothDriving;

	public String SmoothDriving() {
		return SmoothDriving.getText();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Mobile Use']")
	private WebElement MobileUse;

	public String MobileUse() {
		return MobileUse.getText();
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Speed']")
	private WebElement Speed;

	public String Speed() {
		return Speed.getText();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Fatigue']")
	private WebElement Fatigue;

	public String Fatigue() {
		return Fatigue.getText();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Time of Day']")
	private WebElement TimeofDay;

	public String TimeofDay() {
		return TimeofDay.getText();
	}
	
	//Preferences page
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='More']")
	private WebElement MoreButton;

	public void MoreButton() {
		MoreButton.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/navigation_title']")
	private WebElement MoreDisplay;
	
	public String MoreDisplay() {
		return MoreDisplay.getText();
	}
	
	
	@FindBy(xpath = "//android.widget.TextView[@text='Preferences']")
	private WebElement Preferences;

	public void Preferences() {
		Preferences.click();
	}
	
	
	public String PreferencesText() {
		return Preferences.getText();
	}
	
	
	@FindBy(xpath = "//android.widget.CheckBox[@resource-id='android:id/checkbox']")
	private WebElement CheckBox;

	public void CheckBox() {
		CheckBox.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/index_0']")
	private WebElement fifteenpercentage;

	public void fifteenpercentage() {
		fifteenpercentage.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/index_1']")
	private WebElement twentypercentage;

	public void twentypercentage() {
		twentypercentage.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/index_2']")
	private WebElement twentyfivepercentage;

	public void twentyfivepercentage() {
		twentyfivepercentage.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/index_3']")
	private WebElement thirtypercentage;

	public void thirtypercentage() {
		thirtypercentage.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/rb_units_1']")
	private WebElement auto;

	public void auto() {
		auto.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/rb_units_2']")
	private WebElement imperial;

	public void imperial() {
		imperial.click();
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/rb_units_3']")
	private WebElement metric;

	public void metric() {
		metric.click();
	}
	
	@FindBy(xpath = "(//android.widget.CheckBox[@resource-id='android:id/checkbox'])[2]")
	private WebElement CheckBox2;

	public void CheckBox2() {
		CheckBox2.click();
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/navigation_back']")
	private WebElement BackButtonPreference;

	public void BackButtonPreference() {
		BackButtonPreference.click();
	}
	
	
	//FAQs
	@FindBy(xpath = "//android.widget.TextView[@text='FAQs']")
	private WebElement FAQs;

	public void FAQs() {
		FAQs.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Terms and Conditions']")
	private WebElement Journeyrecording;

	public void Journeyrecording() {
		Journeyrecording.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/list_item_text_id']")
	private WebElement automaticjourneyrecording;

	public void automaticjourneyrecording() {
		automaticjourneyrecording.click();
	}
	
	//Terms and Conditions
	@FindBy(xpath = "//android.widget.TextView[@text='Terms and Conditions']")
	private WebElement TermsandConditions;

	public void TermsandConditions() {
		TermsandConditions.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Optimizations']")
	private WebElement Optimizations;

	public WebElement Optimizations() {
		return Optimizations;
	}
	
	public void OptimizationsButton() {
		Optimizations.click();;
	}
	
	
	@FindBy(xpath = "//android.widget.TextView[@text='Tap for more info']")
	private WebElement AddaptiveBattery;
	
	public void AddaptiveBattery() {
		AddaptiveBattery.click();;
	}

	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/next']")
	private WebElement AddaptiveBatterynextBtn;

	public void AddaptiveBatterynextBtn() {
		AddaptiveBatterynextBtn.click();
	}
	
	//Change password
	@FindBy(xpath = "//android.widget.TextView[@text='Change Password']")
	private WebElement Changepassword;

	public void Changepassword() {
		Changepassword.click();
	}
	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/tooltip_image'])[1]")
	private WebElement Currentpasswordsign;

	public void Currentpasswordsign() {
		Currentpasswordsign.click();
	}
	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/tooltip_image'])[2]")
	private WebElement Newpasswordsign;

	public void Newpasswordsign() {
		Newpasswordsign.click();
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input'])[1]")
	private WebElement CurrentpasswordTextbox;

	public void CurrentpasswordTextbox(String value) {
		CurrentpasswordTextbox.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input'])[2]")
	private WebElement NewpasswordTextbox;

	public void NewpasswordTextbox(String value) {
		NewpasswordTextbox.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input'])[3]")
	private WebElement RepeatpasswordTextbox;

	public void RepeatpasswordTextbox(String value) {
		RepeatpasswordTextbox.sendKeys(value);
	}
	
	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/password_show'])[1]")
	private WebElement CurrentpasswordShow;

	public void CurrentpasswordShow() {
		CurrentpasswordShow.click();
	}
	
	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/password_show'])[2]")
	private WebElement NewpasswordShow;

	public void NewpasswordShow() {
		NewpasswordShow.click();
	}
	
	@FindBy(xpath = "//android.widget.Button[@text='Change it']")
	private WebElement ChangeIt;

	public void ChangeIt() {
		ChangeIt.click();
	}
	
	//About
	@FindBy(xpath = "//android.widget.TextView[@text='About']")
	private WebElement About;

	public void About() {
		About.click();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/logout']")
	private WebElement Logout;

	public void Logout() {
		Logout.click();
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.thefloow.thefloowltd.floowdrivedemo.app:id/fat_button_1']")
	private WebElement LogoutOk;

	public void LogoutOk() {
		LogoutOk.click();
	}
	
	
}
