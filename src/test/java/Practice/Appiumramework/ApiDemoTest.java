package Practice.Appiumramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Dependencies;
import pageObjects.HomePage;
import pageObjects.Preference;
public class ApiDemoTest extends Base_eCommApp {
			
	@Test
	public void apiDemo() throws IOException, InterruptedException {
		service=startServer();
		
		AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 // How to define a xPath
		 // tagName[@attributes='values']
		 // Here in AndroidUIAutomatorViewer, the class name will be the tagName
		 HomePage h=new HomePage(driver);
		 h.Preferences.click();
		 Preference p=new Preference(driver);
		 p.Dependencies.click();
		 Dependencies d=new Dependencies(driver);
		 d.Wifi.click();
		 d.WifiSetting.click();
		 d.WifiName.sendKeys("MrinmoyKumarBiswas");
		 d.WifiClickOK.get(1).click();		 		 
		 
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		// driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		// driver.findElementById("android:id/checkbox").click();
		// driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		 //In this above technique, we need to put the class name inside the brackets then we have to use [2]
		 // This is same as above		 
		 // driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		// driver.findElementByClassName("android.widget.EditText").sendKeys("MrinmoyKumarBiswas");
		// driver.findElementsByClassName("android.widget.Button").get(1).click();
		 // Here first we'll find all the Objects  then filter it out based on the provided index. 
		 //driver.findElementById("android:id/button1").click();	
		service.stop();
	}
	
	
	

		
		
		
	
	
}
