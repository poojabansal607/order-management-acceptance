package com.steps;

import com.sapient.impl.OrderManagementImpl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderManagementSteps {
	
	 @Given("^user is on create order page$")
	    public void I_am_on_the_create_order_page() throws Throwable {
		 OrderManagementImpl createOrder = new OrderManagementImpl();
		 createOrder.navigateToCreateOrderPage();
	    }
	 
	  @When("^user submit order having ticker \"([^\"]*)\" with quantity \"([^\"]*)\"$")
	     public void user_submit_order_with_quantity(String ticker, String quantity) throws Throwable {
		  	OrderManagementImpl order = new OrderManagementImpl();
		  	order.enterOrder(ticker,quantity,"");
	     }
	  
	  @When("^user submit limit order having ticker \"([^\"]*)\" with quantity \"([^\"]*)\" and limit price \"([^\"]*)\"$")
	     public void user_submit_order_with_quantity_and_limitprice(String ticker, String quantity, String limitprice) throws Throwable {
		  	OrderManagementImpl order = new OrderManagementImpl();
		  	order.selectOrderType("Limits");
		  	order.enterOrder(ticker,quantity,limitprice);
	     }
	  
	  @When("^user submit limit order having ticker \"([^\"]*)\" with quantity \"([^\"]*)\" and blank limit price$")
	     public void user_submit_order_with_quantity_and_blanklimitprice(String ticker, String quantity) throws Throwable {
		  	OrderManagementImpl order = new OrderManagementImpl();
		  	order.selectOrderType("Limits");
		  	order.enterOrder(ticker, quantity,"");
	     }
	

	  @Then("^result should display the home page$")
	     public void result_should_display_the_home_page() throws Throwable {
		   OrderManagementImpl order = new OrderManagementImpl();
		   order.verifyHomePage();
		  }
	  
	  @Then("^result should display the view page$")
	     public void result_should_display_the_view_page() throws Throwable {
		   OrderManagementImpl order = new OrderManagementImpl();
		   order.verifyViewPage();
		  }
	  
	  @Then("^there should be an error with message \"([^\"]*)\"$")
	     public void error_withmessage(String errorMessage) throws Throwable {
		   OrderManagementImpl order = new OrderManagementImpl();
		   order.verifyErrorMessage(errorMessage);
		  }

}
