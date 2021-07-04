package pageObjects;
// All the object belong to one page will be ion one Java class
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class HomePage {
	public HomePage(AndroidDriver<AndroidElement> driver) {
		//PageFactory.initElements(driver, this);		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);	
		// new AppiumFieldDecorator(driver)
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	//public MobileElement Preferences;
	 public WebElement Preferences;
}
