package com.tests;

import org.testng.annotations.*;

import com.pageobject.amazon.AmazonFront;
import com.pageobject.amazon.AmazonCart;
import com.pageobject.amazon.AmazonHome;
import com.pageobject.amazon.AmazonLogin;
import com.pageobject.amazon.AmazonShopByCategory;
import com.test.amazon.android.BaseClass;
import com.test.amazon.android.WebDriverWaitUtils;

public class ProductPurchase extends BaseClass {
	
	private AmazonFront AmazonFront;
	private AmazonHome AmazonHome;
	private AmazonShopByCategory AmazonShopByCategory;
	private AmazonCart AmazonCart;
	private AmazonLogin AmazonLogin;
	

	
	@Test
	public void purchaseProduct() throws Exception{
		
		AmazonFront = new AmazonFront();
		AmazonHome = new AmazonHome();
		AmazonShopByCategory = new AmazonShopByCategory();
		AmazonCart = new AmazonCart();
		AmazonLogin = new AmazonLogin();
		
		WebDriverWaitUtils.waitElementToBeVisible(AmazonFront.btnSkipSignIn);
		AmazonFront.clickSkip_Sign_In();
		AmazonHome.clickShopByCategory();
		AmazonShopByCategory.selectProductCategory_Echo_Alexa();
		AmazonShopByCategory.selectProductCategory_Kindle_Store();
		AmazonShopByCategory.selectProductCategory_Amazon_Fire_TV_Stick();
		AmazonShopByCategory.selectProduct2Category_Echo_Alexa();
//		AmazonShopByCategory.selectProductCategory_TV_Appliances_Electronics();
		AmazonCart.proceedToCheckOut();
		AmazonLogin.login();
		AmazonLogin.verifyDeliverToAddress();
	}
}
