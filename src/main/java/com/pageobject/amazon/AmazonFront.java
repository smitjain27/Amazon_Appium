package com.pageobject.amazon;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.amazon.android.BaseClass;
import com.test.amazon.android.WebDriverWaitUtils;

public class AmazonFront extends BaseClass {


	@AndroidFindBy(id="sign_in_button") 
	public WebElement btnSignInID;
	@AndroidFindBy(id="skip_sign_in_button") 
	public WebElement btnSkipSignIn;
	
	public AmazonFront() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void clickSkip_Sign_In(){
		WebDriverWaitUtils.waitElementToBeVisible(btnSkipSignIn);
		btnSkipSignIn.click();
	}
	
	

}
