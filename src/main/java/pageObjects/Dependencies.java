package pageObjects;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Dependencies {
	public Dependencies(AndroidDriver<AndroidElement> driver) {
		//PageFactory.initElements(driver, this);		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);	
		
		// new AppiumFieldDecorator(driver)
	}
	@AndroidFindBy(id="android:id/checkbox")
	 public WebElement Wifi;
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	 public WebElement WifiSetting;
	
	@AndroidFindBy(className="android.widget.EditText")
	 public WebElement WifiName;
	
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> WifiClickOK;
}
