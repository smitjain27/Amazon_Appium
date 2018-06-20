package com.pageobject.amazon;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.amazon.android.BaseClass;
import com.test.amazon.android.WebDriverWaitUtils;

public class AmazonShopByCategory extends BaseClass {

	@AndroidFindBy(xpath="//android.view.View[@text='Echo & Alexa']") 
	public WebElement lbl_Category_Echo_Alexa;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Echo Dot ']") 
	public WebElement lbl_Echo_Alexa_Echo_Dot ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Amazon Echo '][@index='2']") 
	public WebElement lbl_Alexa_Echo ;
		
	@AndroidFindBy(xpath="//android.view.View[@text='Deliver to']") 
	public WebElement lblDeliverTo ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Echo Devices ']") 
	public WebElement lbl_EchoDevices ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='FREE Delivery']") 
	public WebElement lblFREEDelivery ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Alexa See how it works']") 
	public WebElement btnHowItWorks ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Add Accessories']") 
	public WebElement lblAdd_Accessories ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Color Name: Black ']") 
	public WebElement btnColor_Name ;
	
	
	@AndroidFindBy(id="loc_ux_gps_enter_pincode") 
	public static WebElement lblEnterPinCode;
	@AndroidFindBy(id="loc_ux_pin_code_text_pt1") 
	public static WebElement inputPinCode_Input_field;
	@AndroidFindBy(id="loc_ux_update_pin_code") 
	public static WebElement btnUpdatePinCode;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to Cart']") 
	public WebElement btnAdd_To_Cart ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to Cart']") 
	public WebElement btnAdd_To_Cart_0 ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Kindle Store']") 
	public WebElement btnCategory_Kindle_Store;
	@AndroidFindBy(xpath="//android.view.View[@text='Kindle E-Readers ']") 
	public WebElement lblKindle_eReader;
	@AndroidFindBy(xpath="//android.view.View[contains(@text, 'High Resolution Display (300 ppi) with Built-in Light, Wi-Fi by Amazon ₹10,999')]") 
	public WebElement lblKindle_Product1;
	@AndroidFindBy(xpath="//android.view.View[@text='Inclusive of all taxes']") 
	public WebElement lblInclusive_of_all_taxes;
	@AndroidFindBy(xpath="//android.view.View[@text='NuPro Slim Fitted Cover for Kindle Paperwhite - black (Black)    1,299 ']") 
	public WebElement lblAdd_Additional_Items;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Mobiles, Computers'][@index='1']") 
	public WebElement btnCategory_Mobiles_Computers;
	@AndroidFindBy(xpath="//android.view.View[@text='Mobiles ']") 
	public WebElement lblMobiles;
	@AndroidFindBy(xpath="//android.view.View[@text='OnePlus 6']") 
	public WebElement lblOnePlus6;
	@AndroidFindBy(xpath="//android.view.View[@text='Without Exchange ₹ 34,999']") 
	public WebElement lblWithOutExchange;
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='TV, Appliances, Electronics'][@index='1']") 
	public WebElement btnCategory_TV_Appliances_Electronics;
	@AndroidFindBy(xpath="//android.view.View[@text='Televisions ']") 
	public WebElement btnTelevisions;
	@AndroidFindBy(xpath="//android.view.View[@text='Sanyo 80 cm (32 inches) XT-32S7000H HD Ready LED TV (Black)']") 
	public WebElement lblSelectTelevision;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Size name: 32 inches ']") 
	public WebElement lblSizeTV;
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='Amazon Fire TV Stick ']") 
	public WebElement btnCategory_Amazon_Fire_TV_Stick ;
	
	@AndroidFindBy(id="action_bar_burger_icon") 
	public static WebElement lblActionBurgerIcon;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Shop by Category']") 
	public static WebElement lblleftSideShobByCategory;
	@AndroidFindBy(id="action_bar_cart_count") 
	public WebElement lblCartCount;
	
	public static int count=0;
	
	public AmazonShopByCategory() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void selectProductCategory_Echo_Alexa() throws InterruptedException{
		WebDriverWaitUtils.waitElementToBeVisible(lbl_Category_Echo_Alexa);
		lbl_Category_Echo_Alexa.click();
		WebDriverWaitUtils.waitElementToBeVisible(lbl_Echo_Alexa_Echo_Dot);
		lbl_Echo_Alexa_Echo_Dot.click();
//		
//		setPincode();
		// Swipe to find Add to Cart
		
		WebDriverWaitUtils.waitElementToBeVisible(lbl_EchoDevices);
		touchActionSwipe(lblFREEDelivery,lbl_EchoDevices);
		
		WebDriverWaitUtils.waitElementToBeVisible(lblAdd_Accessories);
		touchActionSwipe(lblAdd_Accessories,lblFREEDelivery);
		
		
		//click on Add to cart
		WebDriverWaitUtils.waitElementToBeClickable(btnAdd_To_Cart);
		btnAdd_To_Cart.click();
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(lblCartCount);
		String CartCount1="0";
		CartCount1=lblCartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("1", CartCount1);
		System.out.println("Product Added Successfully");
			
	}
	
	public void selectProduct2Category_Echo_Alexa() throws InterruptedException{
		goToCategoryPage();
		
		WebDriverWaitUtils.waitElementToBeVisible(lbl_Category_Echo_Alexa);
		lbl_Category_Echo_Alexa.click();
		WebDriverWaitUtils.waitElementToBeVisible(lbl_Alexa_Echo);
		lbl_Alexa_Echo.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lbl_EchoDevices);
		touchActionSwipe(btnHowItWorks,lbl_EchoDevices);
		
		//Hard wait as some other functionality perform intermittent
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(lblAdd_Accessories);
		touchActionSwipe(lblAdd_Accessories,lbl_EchoDevices);
		
		
		//click on Add to cart
		WebDriverWaitUtils.waitElementToBeClickable(btnAdd_To_Cart);
		btnAdd_To_Cart.click();
		
		// Hard wait to update the cart count
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(lblCartCount);
		String CartCount1="0";
		CartCount1=lblCartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("4", CartCount1);
		System.out.println("Product Added Successfully");
			
	}
	
		
	public static void goToCategoryPage(){
		WebDriverWaitUtils.waitElementToBeVisible(lblActionBurgerIcon);
		lblActionBurgerIcon.click();
		WebDriverWaitUtils.waitElementToBeVisible(lblleftSideShobByCategory);
		lblleftSideShobByCategory.click();
	}
	
	public void selectProductCategory_Kindle_Store() throws InterruptedException{
		goToCategoryPage();
		
		WebDriverWaitUtils.waitElementToBeVisible(btnCategory_Kindle_Store);
		btnCategory_Kindle_Store.click();
		WebDriverWaitUtils.waitElementToBeVisible(lblKindle_eReader);
		lblKindle_eReader.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblKindle_Product1);
		lblKindle_Product1.click();
		
		setPincode();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblDeliverTo);
		touchActionSwipe(lblInclusive_of_all_taxes,lblDeliverTo);
		
		WebDriverWaitUtils.waitElementToBeVisible(lblAdd_Additional_Items);
		touchActionSwipe(lblAdd_Additional_Items,lblInclusive_of_all_taxes);
		
		//click on Add to cart
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeClickable(btnAdd_To_Cart);
		btnAdd_To_Cart.click();
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(lblCartCount);
		String CartCount1="0";
		CartCount1=lblCartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("2", CartCount1);
		System.out.println("Product Added Successfully");
			
	}
	
	public void selectProductCategory_Amazon_Fire_TV_Stick() throws InterruptedException{
		goToCategoryPage();
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(btnCategory_Amazon_Fire_TV_Stick);
		btnCategory_Amazon_Fire_TV_Stick.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblDeliverTo);
		touchActionSwipe(lblFREEDelivery,lblDeliverTo);
		
		WebDriverWaitUtils.waitElementToBeVisible(lblFREEDelivery);
		touchActionSwipe(lblAdd_Accessories,lblFREEDelivery);
		
		//click on Add to cart
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeClickable(btnAdd_To_Cart);
		btnAdd_To_Cart.click();
		
		Thread.sleep(4000);
		WebDriverWaitUtils.waitElementToBeVisible(lblCartCount);
		String CartCount1="0";
		CartCount1=lblCartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("3", CartCount1);
		System.out.println("Product Added Successfully");
	}
	
	public void selectProductCategory_Mobiles_Computers() throws InterruptedException{
		goToCategoryPage(); 
		
		WebDriverWaitUtils.waitElementToBeVisible(btnCategory_Mobiles_Computers);
		btnCategory_Mobiles_Computers.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblMobiles);
		lblMobiles.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblOnePlus6);
		lblOnePlus6.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblFREEDelivery);
		touchActionSwipe(lblFREEDelivery, lblDeliverTo);
		
		Thread.sleep(5000);
		WebDriverWaitUtils.waitElementToBeVisible(lblFREEDelivery);
		touchActionSwipe(lblWithOutExchange, lblFREEDelivery);
		
		Thread.sleep(5000);
		WebDriverWaitUtils.waitElementToBeClickable(btnAdd_To_Cart);
		btnAdd_To_Cart.click();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(lblCartCount);
		String CartCount1="0";
		CartCount1=lblCartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("4", CartCount1);
		System.out.println("Product Added Successfully");
	}
	
	public void selectProductCategory_TV_Appliances_Electronics() throws InterruptedException{
		goToCategoryPage();
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(btnCategory_TV_Appliances_Electronics);
		btnCategory_TV_Appliances_Electronics.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(btnTelevisions);
		btnTelevisions.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblSelectTelevision);
		lblSelectTelevision.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(lblSizeTV);
		touchActionSwipe(lblSizeTV, lblDeliverTo);
		
		WebDriverWaitUtils.waitElementToBeVisible(lblSizeTV);
		touchActionSwipe(lblInclusive_of_all_taxes, lblSizeTV);
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeClickable(btnAdd_To_Cart_0);
		btnAdd_To_Cart_0.click();
		
		Thread.sleep(5000);
		WebDriverWaitUtils.waitElementToBeVisible(lblCartCount);
		String CartCount1="0";
		CartCount1=lblCartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("5", CartCount1);
		System.out.println("Product Added Successfully");
	}
	
	public static void setPincode(){
		if(count==0){
			for(int i=1; i<=2; i++){
				try{
					WebDriverWaitUtils.waitElementToBeVisible(lblEnterPinCode);
					lblEnterPinCode.click();
					WebDriverWaitUtils.waitElementToBeVisible(inputPinCode_Input_field);
					inputPinCode_Input_field.clear();
					inputPinCode_Input_field.sendKeys("560076");
					btnUpdatePinCode.click();
					count=count+1;
				}
				catch(Exception e){
					
					System.out.println("Use my current option didn't appear");
					break;
				}
			}
		
		}
		
	}
	
	public static void touchActionSwipe(WebElement el1, WebElement el2){
		TouchAction ta = new TouchAction(driver);
		ta.press(el1).moveTo(el2).release().perform();
	}
	

}
