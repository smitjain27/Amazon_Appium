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

public class AmazonLogin extends BaseClass {


	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='ap_email_login']") 
	public WebElement inputFieldEmail_Phone ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='continue']") 
	public WebElement btnContinue ;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='ap_password']") 
	public WebElement inputFieldPassword ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Login. Already a customer? ']") 
	public WebElement btn_Login ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Select a delivery address']") 
	public WebElement lbl_SelectAddress ;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Deliver to this address')]") 
	public WebElement btn_DeliverAddress ;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']") 
	public WebElement btnSignInSubmit ;
	
	
	public AmazonLogin() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void login(){
		
		WebDriverWaitUtils.waitElementToBeVisible(btn_Login);
		btn_Login.click();
		WebDriverWaitUtils.waitElementToBeVisible(inputFieldEmail_Phone);
		inputFieldEmail_Phone.clear();
		inputFieldEmail_Phone.sendKeys("9663310652");
		WebDriverWaitUtils.waitElementToBeVisible(btnContinue);
		btnContinue.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(inputFieldPassword);
		inputFieldPassword.clear();
		inputFieldPassword.sendKeys("0123neha");
		
		WebDriverWaitUtils.waitElementToBeVisible(btnSignInSubmit);
		btnSignInSubmit.click();
		
		
	}
	
	public void verifyDeliverToAddress(){
		WebDriverWaitUtils.waitElementToBeVisible(lbl_SelectAddress);
		
	}

}
