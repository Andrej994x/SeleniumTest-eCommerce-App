package uk.co.automationstesting;

import java.io.IOException;


import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import PageObjects.OrderFormDelivery;
import PageObjects.OrderFormPayment;
import PageObjects.OrderFormPersInfo;
import PageObjects.OrderFormShippingMethod;
import PageObjects.ShopContentPanel;
import PageObjects.ShopHomePage;
import PageObjects.ShopProductPage;
import PageObjects.ShoppingCart;

import base.Hooks;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
	}

	@Test
	public void endToEndTest() throws InterruptedException, IOException {

	
		Homepage home = new Homepage();
		home.getTestStoreLink().click();

		
		ShopHomePage shopHome = new ShopHomePage();
		shopHome.getProdOne().click();

	
		ShopProductPage shopProd = new ShopProductPage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		cart.getProceedCheckoutBtn().click();

		
		OrderFormPersInfo pInfo = new OrderFormPersInfo();
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("Andrej");
		pInfo.getLastnameField().sendKeys("Nestorov");
		pInfo.getEmailField().sendKeys("nestorov.andrej@hotmail.com");
		pInfo.getTermsConditionsCheckbox().click();
		pInfo.getContinueBtn().click();

		
		OrderFormDelivery orderDelivery = new OrderFormDelivery();
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77021");
		orderDelivery.getContinueBtn().click();

		
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();

		
		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
	}

}
