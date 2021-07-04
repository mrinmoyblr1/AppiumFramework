package Practice.Appiumramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;
import pageObjects.ProductPage;
import pageObjects.CheckoutPage;
public class Ecommerce_TC_4 extends Base_eCommApp {
	
	
	@BeforeTest
	public void killAllTheOpenNodes() throws IOException {
		killAllNodes();	
	}
	
	@Test
	public void totalValidation() throws IOException, InterruptedException {

		
		service=startServer();
		startEmulator();
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		FormPage fp=new FormPage(driver);
		fp.getNameField().sendKeys("Mrinmoy");
		fp.hideKeyboard(driver);
		fp.getFemaleOption().click();
		fp.getCountrySelection().click();
		CheckoutPage ckp=new CheckoutPage(driver);
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Mrinmoy");
		//driver.hideKeyboard();
		// It will hide the Keyboard
		//driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		//driver.findElement(By.id("android:id/text1")).click();
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"Argentina\"))");
		// This is the alternate approach to scroll in Android device.
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
//						+ "Argentina" + "\").instance(0))"));
		Utilities ut=new Utilities(driver);
		ut.scrollToText("Argentina");		
		//driver.findElementByXPath("//*[@text='Argentina']").click();
		fp.getSelectCountry().click();		
		//driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		fp.getClickButtonLetsShop().click();
		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		ProductPage productPageObject=new ProductPage(driver);
		productPageObject.getAddProductToCart().get(0).click();
		productPageObject.getAddProductToCart().get(1).click();		
		//driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		//driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		productPageObject.getClickOnCartButton().click();
		//driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);		
		int size=ckp.getProductList().size();
		double sum=0;
		for(int i=0;i<size;i++)
		{
			String amount=ckp.getProductList().get(i).getText();
			double amount1Value=getAmount(amount);
			sum=sum+amount1Value;
		}
		System.out.println("The Sum of the Products: "+sum);
		String total=ckp.getTotalAmount().getText();
		double totalValue=getAmount(total);
		System.out.println("The Total values from the Cart Total: "+totalValue);
		Assert.assertEquals(sum, totalValue);
		
		service.stop();
	}
	public static double getAmount(String value)
	{
		value=value.substring(1);
		double amount1Value=Double.parseDouble(value);
		return amount1Value;
	}
}
