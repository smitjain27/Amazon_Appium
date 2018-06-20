package com.pageobject.amazon;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.amazon.android.BaseClass;
import com.test.amazon.android.WebDriverWaitUtils;

public class AmazonCart extends BaseClass {


	@AndroidFindBy(xpath="//android.view.View[@text='Cart Subtotal (4 items): ']") 
	public WebElement lbl_Total_Cart_Items ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed to Checkout']") 
	public WebElement btn_Proceed_To_Checkout ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Login. Already a customer? ']") 
	public WebElement btn_Login ;
	
	@AndroidFindBy(id="action_bar_cart_count") 
	public WebElement cartCount;

	public AmazonCart() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void proceedToCheckOut(){
		WebDriverWaitUtils.waitElementToBeVisible(cartCount);
		cartCount.click();
		WebDriverWaitUtils.waitElementToBeVisible(lbl_Total_Cart_Items);
		WebDriverWaitUtils.waitElementToBeVisible(btn_Proceed_To_Checkout);
		btn_Proceed_To_Checkout.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(btn_Login);
		
	}
	

}
