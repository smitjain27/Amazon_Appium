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
	public WebElement category_Echo_Alexa;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Echo Dot ']") 
	public WebElement Echo_Alexa_Echo_Dot ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Deliver to']") 
	public WebElement DeliverTo ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Select your address']") 
	public WebElement Select_your_address ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='FREE Delivery']") 
	public WebElement FREEDelivery ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Add Accessories']") 
	public WebElement Add_Accessories ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Color Name: Black ']") 
	public WebElement Color_Name ;
	
	
	@AndroidFindBy(id="loc_ux_gps_enter_pincode") 
	public static WebElement EnterPinCode;
	@AndroidFindBy(id="loc_ux_pin_code_text_pt1") 
	public static WebElement PinCode_Input_field;
	@AndroidFindBy(id="loc_ux_update_pin_code") 
	public static WebElement UpdatePinCode;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to Cart']") 
	public WebElement Add_To_Cart ;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Kindle Store']") 
	public WebElement category_Kindle_Store;
	@AndroidFindBy(xpath="//android.view.View[@text='Kindle E-Readers ']") 
	public WebElement kindle_eReader;
	@AndroidFindBy(xpath="//android.view.View[contains(@text, 'High Resolution Display (300 ppi) with Built-in Light, Wi-Fi by Amazon ₹10,999')]") 
	public WebElement kindle_Product1;
	@AndroidFindBy(xpath="//android.view.View[@text='Inclusive of all taxes']") 
	public WebElement Inclusive_of_all_taxes;
	@AndroidFindBy(xpath="//android.view.View[@text='NuPro Slim Fitted Cover for Kindle Paperwhite - black (Black)    1,299 ']") 
	public WebElement Add_Additional_Items;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Mobiles, Computers'][@index='1']") 
	public WebElement category_Mobiles_Computers;
	@AndroidFindBy(xpath="//android.view.View[@text='Mobiles ']") 
	public WebElement Mobiles;
	@AndroidFindBy(xpath="//android.view.View[@text='OnePlus 6']") 
	public WebElement OnePlus6;
	@AndroidFindBy(xpath="//android.view.View[@text='Without Exchange ₹ 34,999']") 
	public WebElement withOutExchange;
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='TV, Appliances, Electronics'][@index='1']") 
	public WebElement category_TV_Appliances_Electronics;
	@AndroidFindBy(xpath="//android.view.View[@text='Televisions ']") 
	public WebElement Televisions;
	@AndroidFindBy(xpath="//android.view.View[@text='Sanyo 80 cm (32 inches) XT-32S7000H HD Ready LED TV (Black)']") 
	public WebElement selectTelevision;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Size name: 32 inches ']") 
	public WebElement sizeTV;
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='Amazon Fire TV Stick ']") 
	public WebElement category_Amazon_Fire_TV_Stick ;
	
	@AndroidFindBy(id="action_bar_burger_icon") 
	public static WebElement actionBurgerIcon;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Shop by Category']") 
	public static WebElement leftSideShobByCategory;
	@AndroidFindBy(id="action_bar_cart_count") 
	public WebElement cartCount;
	
	public static int count=0;
	
	public AmazonShopByCategory() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void selectProductCategory_Echo_Alexa() throws InterruptedException{
		WebDriverWaitUtils.waitElementToBeVisible(category_Echo_Alexa);
		category_Echo_Alexa.click();
		WebDriverWaitUtils.waitElementToBeVisible(Echo_Alexa_Echo_Dot);
		Echo_Alexa_Echo_Dot.click();
//		
		setPincode();
		// Swipe to find Add to Cart
		if(count==1){
			WebDriverWaitUtils.waitElementToBeVisible(DeliverTo);
			touchActionSwipe(FREEDelivery,DeliverTo);
		}else{
		WebDriverWaitUtils.waitElementToBeVisible(Select_your_address);
		touchActionSwipe(FREEDelivery,Select_your_address);
		}
		WebDriverWaitUtils.waitElementToBeVisible(Add_Accessories);
		touchActionSwipe(Add_Accessories,Color_Name);
		
		
		//click on Add to cart
		WebDriverWaitUtils.waitElementToBeClickable(Add_To_Cart);
		Add_To_Cart.click();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(cartCount);
		String CartCount1="0";
		CartCount1=cartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("1", CartCount1);
		System.out.println("Product Added Successfully");
			
	}
	
	public static void touchActionSwipe(WebElement el1, WebElement el2){
		TouchAction ta = new TouchAction(driver);
		ta.press(el1).moveTo(el2).release().perform();
	}
	
	public static void setPincode(){
		if(count==0){
			for(int i=1; i<=2; i++){
				try{
					WebDriverWaitUtils.waitElementToBeVisible(EnterPinCode);
					EnterPinCode.click();
					WebDriverWaitUtils.waitElementToBeVisible(PinCode_Input_field);
					PinCode_Input_field.clear();
		//			PinCode_Input_field.click();
					PinCode_Input_field.sendKeys("560076");
					UpdatePinCode.click();
					count=count+1;
				}
				catch(Exception e){
					
					System.out.println("Use my current option didn't appear");
					break;
				}
			}
		
		}
		
	}
	
	public static void goToCategoryPage(){
		WebDriverWaitUtils.waitElementToBeVisible(actionBurgerIcon);
		actionBurgerIcon.click();
		WebDriverWaitUtils.waitElementToBeVisible(leftSideShobByCategory);
		leftSideShobByCategory.click();
	}
	
	public void selectProductCategory_Kindle_Store() throws InterruptedException{
		goToCategoryPage();
		
		WebDriverWaitUtils.waitElementToBeVisible(category_Kindle_Store);
		category_Kindle_Store.click();
		WebDriverWaitUtils.waitElementToBeVisible(kindle_eReader);
		kindle_eReader.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(kindle_Product1);
		kindle_Product1.click();
		
		setPincode();
		
		WebDriverWaitUtils.waitElementToBeVisible(DeliverTo);
		touchActionSwipe(Inclusive_of_all_taxes,DeliverTo);
		
		WebDriverWaitUtils.waitElementToBeVisible(Add_Additional_Items);
		touchActionSwipe(Add_Additional_Items,Inclusive_of_all_taxes);
		
		//click on Add to cart
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeClickable(Add_To_Cart);
		Add_To_Cart.click();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(cartCount);
		String CartCount1="0";
		CartCount1=cartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("2", CartCount1);
		System.out.println("Product Added Successfully");
			
	}
	
	public void selectProductCategory_Amazon_Fire_TV_Stick() throws InterruptedException{
		goToCategoryPage();
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(category_Amazon_Fire_TV_Stick);
		category_Amazon_Fire_TV_Stick.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(DeliverTo);
		touchActionSwipe(FREEDelivery,DeliverTo);
		
		WebDriverWaitUtils.waitElementToBeVisible(FREEDelivery);
		touchActionSwipe(Add_Accessories,FREEDelivery);
		
		//click on Add to cart
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeClickable(Add_To_Cart);
		Add_To_Cart.click();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(cartCount);
		String CartCount1="0";
		CartCount1=cartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("3", CartCount1);
		System.out.println("Product Added Successfully");
	}
	
	public void selectProductCategory_Mobiles_Computers() throws InterruptedException{
		goToCategoryPage(); 
		
		WebDriverWaitUtils.waitElementToBeVisible(category_Mobiles_Computers);
		category_Mobiles_Computers.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(Mobiles);
		Mobiles.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(OnePlus6);
		OnePlus6.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(FREEDelivery);
		touchActionSwipe(FREEDelivery, DeliverTo);
		
		Thread.sleep(5000);
		WebDriverWaitUtils.waitElementToBeVisible(FREEDelivery);
		touchActionSwipe(withOutExchange, FREEDelivery);
		
		Thread.sleep(5000);
		WebDriverWaitUtils.waitElementToBeClickable(Add_To_Cart);
		Add_To_Cart.click();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(cartCount);
		String CartCount1="0";
		CartCount1=cartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("4", CartCount1);
		System.out.println("Product Added Successfully");
	}
	
	public void selectProductCategory_TV_Appliances_Electronics() throws InterruptedException{
		goToCategoryPage();
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeVisible(category_TV_Appliances_Electronics);
		category_TV_Appliances_Electronics.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(Televisions);
		Televisions.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(selectTelevision);
		selectTelevision.click();
		
		WebDriverWaitUtils.waitElementToBeVisible(sizeTV);
		touchActionSwipe(sizeTV, DeliverTo);
		
		WebDriverWaitUtils.waitElementToBeVisible(Inclusive_of_all_taxes);
		touchActionSwipe(Inclusive_of_all_taxes, sizeTV);
		
		Thread.sleep(2000);
		WebDriverWaitUtils.waitElementToBeClickable(Add_To_Cart);
		Add_To_Cart.click();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(cartCount);
		String CartCount1="0";
		CartCount1=cartCount.getAttribute("text");
		System.out.println("Cart count value is: "+ CartCount1);
		
		//Verify product added in the cart
		Assert.assertEquals("5", CartCount1);
		System.out.println("Product Added Successfully");
	}
	
	
	

}
