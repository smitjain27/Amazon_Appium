package com.pageobject.amazon;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.amazon.android.BaseClass;
import com.test.amazon.android.WebDriverWaitUtils;

public class AmazonHome extends BaseClass {


	@AndroidFindBy(id="web_home_shop_by_department_label") 
	public WebElement lblShopByCategory_Label;
	
	@AndroidFindBy(id="action_bar_burger_icon") 
	public WebElement btnActionBurgerIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Shop by Category']") 
	public WebElement lblLeftSideShobByCategory;
	
	@AndroidFindBy(id="action_bar_cart_count") 
	public WebElement lblCartCount;

	
	public AmazonHome() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void clickShopByCategory(){
		WebDriverWaitUtils.waitElementToBeVisible(lblShopByCategory_Label);
		lblShopByCategory_Label.click();
	}
	
	

}
