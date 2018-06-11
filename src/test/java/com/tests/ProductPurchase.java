package com.tests;

import org.testng.annotations.*;

import com.pageobject.amazon.AmazonFront;
import com.pageobject.amazon.AmazonHome;
import com.pageobject.amazon.AmazonShopByCategory;
import com.test.amazon.android.BaseClass;
import com.test.amazon.android.WebDriverWaitUtils;

public class ProductPurchase extends BaseClass {
	
	private AmazonFront AmazonFront;
	private AmazonHome AmazonHome;
	private AmazonShopByCategory AmazonShopByCategory;
	

	
	@Test
	public void purchaseProduct() throws Exception{
		
		AmazonFront = new AmazonFront();
		AmazonHome = new AmazonHome();
		AmazonShopByCategory = new AmazonShopByCategory();
		
		
		WebDriverWaitUtils.waitElementToBeVisible(AmazonFront.skipSignIn);
		AmazonFront.clickSkip_Sign_In();
		AmazonHome.clickShopByCategory();
		AmazonShopByCategory.selectProductCategory_Echo_Alexa();
		AmazonShopByCategory.selectProductCategory_Kindle_Store();
		AmazonShopByCategory.selectProductCategory_Amazon_Fire_TV_Stick();
		AmazonShopByCategory.selectProductCategory_Mobiles_Computers();
		AmazonShopByCategory.selectProductCategory_TV_Appliances_Electronics();
		
	}
}
