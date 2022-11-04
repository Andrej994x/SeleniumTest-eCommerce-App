package uk.co.automationstesting;

import java.io.IOException;



import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import PageObjects.ShopContentPanel;
import PageObjects.ShopHomePage;
import PageObjects.ShopProductPage;
import PageObjects.ShoppingCart;

import base.Hooks;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

	public AddRemoveItemBasketTest() throws IOException {
		super();

	}



	@Test
	public void AddRemoveItem() throws IOException {
		Homepage home = new Homepage();
		home.getTestStoreLink().click();

		ShopHomePage shopHome = new ShopHomePage();
		shopHome.getProdOne().click();

		ShopProductPage shopProd = new ShopProductPage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		// Thread.sleep(5000);

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart();
		cart.getDeleteItemTwo().click();
		
		waitForElementInvisible(cart.getDeleteItemTwo(), 10);
		
		System.out.println(cart.getTotalAmount().getText()); 
		
	
		
		Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24");
	}

}
