package Practice.Appiumramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
public class Base_eCommApp {
	//To start Appium Server automatically.
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;
	public AppiumDriverLocalService startServer() {
		boolean flag=checkIfServerIsRunnning(4723);
		if(!flag)
		{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();		
		}
		return service;
	}
	// This code to check is the Appium server is already running.
	public boolean checkIfServerIsRunnning(int port) {
	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    try {
	        serverSocket = new ServerSocket(port);
	        serverSocket.close();
	    } catch (IOException e) {
	        //If control comes here, then it means that the port is in use
	        isServerRunning = true;
	    } finally {
	        serverSocket = null;
	    }
	    return isServerRunning;
	}
	public static void killAllNodes() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}
	public static void startEmulator() throws IOException, InterruptedException  {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");		
		Thread.sleep(6000);
	}
	public static void getScreenshot(String s) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+s+"_"+timestamp+"_screenshot.png"));
	}
//	public static void getScreenshot(String s) throws IOException
//	{
//	File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
//	
//	}
	//System.getProperty("user.dir")+
	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
		// How to get current project path dynamically?
		//System.getProperty("user.dir")
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Practice\\Appiumramework\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		File f=new File("src\\main\\java\\Practice\\Appiumramework");
		File fs=new File(f,(String) prop.get(appName));
		// This DesiredCapabilities 
		DesiredCapabilities cap=new DesiredCapabilities();
		String device=(String) prop.get("device");	
		// startEmulator()
		if(device.contains("emulator"))
		{
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		// Here uiautomator2 is the name which is added later. Recently we are adding this line to invoke the applications.
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		// This will wait till 14 seconds
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		// This fs.getAbsolutePath() will be the absolute path of the APK file. 
		// This is the emulator to automate the Android Applications.
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
		
		
	}
}
