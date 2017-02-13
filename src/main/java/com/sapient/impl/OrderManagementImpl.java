package com.sapient.impl;

import com.sapient.utils.EnvironmentPropertyLoader;
import com.sapient.utils.PropertiesFileUtils;
import org.junit.Assert;

import com.sapient.pages.CreateOrderPage;
import com.sapient.utils.WebDriverUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class OrderManagementImpl {


	public void navigateToCreateOrderPage() throws Exception {

        EnvironmentPropertyLoader environmentPropertyLoader = new EnvironmentPropertyLoader();
        PropertiesFileUtils propertiesFileUtils = environmentPropertyLoader.getPropertyFileUtils();
		
		String host = propertiesFileUtils.propertiesFile.getProperty("serverhost");
		String port = propertiesFileUtils.propertiesFile.getProperty("serverport");
        String contextPath = propertiesFileUtils.propertiesFile.getProperty("contextPath");
		
		WebDriverUtils.getDriver().get("http://"+host+":"+port+"/" + contextPath + "/createOrderAction.htm");

	}

	public void enterOrder(String ticker, String quantity, String limitprice) throws Exception {
		CreateOrderPage orderPage = new CreateOrderPage(WebDriverUtils.getDriver());
		Thread.sleep(2000);
		orderPage.submitOrder(ticker,quantity,limitprice);
	}
	
	public void selectOrderType(String orderType) throws Exception {
		CreateOrderPage orderPage = new CreateOrderPage(WebDriverUtils.getDriver());
		orderPage.selectType(orderType);
		Thread.sleep(1000);
	}

	public void verifyHomePage() throws Exception {
		CreateOrderPage orderPage = new CreateOrderPage(WebDriverUtils.getDriver());
		
		boolean saveResults = orderPage.verifyUserOnHomePage();
		Assert.assertTrue("User is not on Home Page", saveResults);
	}
	
	public void verifyViewPage() throws Exception {
		CreateOrderPage orderPage = new CreateOrderPage(WebDriverUtils.getDriver());
		
		boolean saveResults = orderPage.verifyUserOnViewPage();
		Assert.assertTrue("User is not on View Page", saveResults);
	}
	
	
	public void verifyErrorMessage(String errorMessage) throws Exception {
		CreateOrderPage orderPage = new CreateOrderPage(WebDriverUtils.getDriver());
		
		boolean saveResults = orderPage.verifyErrorOnCreateOrderPage(errorMessage);
		Assert.assertTrue("Error Message was not displayed correctly", saveResults);
	}
}
