package com.sapient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapient.framework.BasePage;



public class CreateOrderPage extends BasePage {
 
	private WebDriver driver;

	@CacheLookup
	@FindBy(name="securityTicker")
	private WebElement tickerInputBox ;
	
	@FindBy(name="quantity")
	private WebElement quantityInputBox ;
	
	@FindBy(name="limitPrice")
	private WebElement limitPriceInputBox;

	@FindBy(id="Save")
	private WebElement saveButton;
	
	@FindBy(id="limit")
	private WebElement limitOrderButton;
	
	@FindBy(id="limitPrice.errors")
	private WebElement limitPriceError;

	public CreateOrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void submitOrder(String ticker, String quantity, String price) throws InterruptedException {
		enterOrderDetails(ticker,quantity,price);
		Thread.sleep(1000);
		save();
	}

	private void enterOrderDetails(String ticker, String quantity, String price) {
		
		tickerInputBox.clear();
		tickerInputBox.sendKeys(ticker);
		quantityInputBox.clear();
		quantityInputBox.sendKeys(quantity);
		limitPriceInputBox.clear();
		limitPriceInputBox.sendKeys(price);
	}

	private void save() {
		saveButton.click();
	}
	
	public void selectType( String type) {
		switch(type) {
		case "Limits":
			limitOrderButton.click();
		}
	}

	public boolean verifyUserOnHomePage() {
		try{
			driver.findElement(By.xpath("//*[@id=\"headingDevops\"]/h4"));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	public boolean verifyUserOnViewPage() {
		try{
			driver.findElement(By.linkText("View Order"));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	public boolean verifyErrorOnCreateOrderPage(String errtext) {
		if (limitPriceError.getText().equalsIgnoreCase(errtext)){
			return true;			
		}
		else {
			return false;
		}
			
			
	}
	
}
