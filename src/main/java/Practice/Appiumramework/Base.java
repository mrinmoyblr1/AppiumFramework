package Practice.Appiumramework;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
public class Base {
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

		File f=new File("src\\main\\java\\Practice\\Appiumramework");
		File fs=new File(f,"original.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		// This DesiredCapabilities 
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Mrinmoyemulator2");		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		// Here uiautomator2 is the name which is added later. Recently we are adding this line to invoke the applications.
		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		// This fs.getAbsolutePath() will be the absolute path of the APK file. 
		// This is the emulator to automate the Android Applications.
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
		
		
		
		
	}
}
