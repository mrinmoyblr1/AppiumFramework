package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	
	public ProductPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addProductToCart;	
	public List<WebElement> getAddProductToCart() {
		System.out.println("Providing value in the Name Field.");
		return addProductToCart;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement clickOnCartButton;	
	public WebElement getClickOnCartButton() {
		System.out.println("Providing value in the Name Field.");
		return clickOnCartButton;
	}
	
	

	
	
	
	

}
