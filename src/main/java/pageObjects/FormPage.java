package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class FormPage {
	
	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;	
	public WebElement getNameField() {
		System.out.println("Providing value in the Name Field.");
		return nameField;
	}
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;	
	public WebElement getFemaleOption() {
		System.out.println("Selecting the Gender Option.");
		return femaleOption;
	}
	
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	public WebElement getCountrySelection() {
		System.out.println("Selecting the Country from the Dropdown.");
		return countrySelection;
	}
	
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	private WebElement selectCountry;
	public WebElement getSelectCountry() {
		return selectCountry;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement clickButtonLetsShop;
	public WebElement getClickButtonLetsShop() {
		return clickButtonLetsShop;
	}
	
	
	
	
	
	
	
	
	// Hiding the Android Keyboard
	public void hideKeyboard(AndroidDriver<AndroidElement> driver) {
		driver.hideKeyboard();
	}
	
}
