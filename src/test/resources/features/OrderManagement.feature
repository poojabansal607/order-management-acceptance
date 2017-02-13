
Feature: Order management Demo

  Scenario Outline: Create Market Order
    Given user is on create order page
    When user submit order having ticker "<ticker>" with quantity "<quantity>"
    Then result should display the view page

    Examples: 
      | ticker | quantity |
      | SAPE   | 9199     |
      
  Scenario Outline: Create Limit Type Order
  	Given user is on create order page
    When user submit limit order having ticker "<ticker>" with quantity "<quantity>" and limit price "<limitprice>"
    Then result should display the view page

    Examples: 
      | ticker | quantity | limitprice |
      | SAPE   | 9199     | 100		 |
      
  Scenario Outline: Negative - Display Error if no limit price is provided for Limit Order
  	Given user is on create order page
    When user submit limit order having ticker "<ticker>" with quantity "<quantity>" and blank limit price
    Then there should be an error with message "Mandatory to enter limit price."

    Examples: 
      | ticker | quantity |
      | SAPE   | 9199     | 
