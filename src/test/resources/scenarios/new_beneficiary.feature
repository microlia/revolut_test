Feature: Add a new beneficiary
  As new user I need an ability to create new beneficiary via mobile app

  Background:
    Given application was not installed before


  @tutorial
  Scenario: New beneficiary user tutorial - Continue button
    Given mobile app is running
    Then I see "Spend without fees" tutorial title
    And I see "When using the RevolutCard, you will get the real exchange rate and spending is always free." tutorial subtitle

    When I click "Continue" button
    Then I see "Track your expenses" tutorial title
    And I see "We'll categorise your purchases to show you exactly how much you're spending, on what, and where!" tutorial subtitle

    When I click "Continue" button
    Then I see "Exchange currencies" tutorial title
    And I see "Exchange between currencies instantly in the app and lock in a great rate." tutorial subtitle

    When I click "Continue" button
    Then I see "Control your card security" tutorial title
    And I see "You can disabled ATM transactions, contactless payments and so much more!" tutorial subtitle

    When I click "Continue" button
    Then I see "Transfer money globally" tutorial title
    And I see "Send money abroad for free with Revolut. Transfer money to any bank, business or friend at the real exchange rate." tutorial subtitle

    When I click "Continue" button
    Then sign up form is displayed


  @tutorial
  Scenario: Skip reading beneficiary user tutorial
    Given mobile app is running
    Then I see "Spend without fees" tutorial title

    When I click "Skip" button
    Then sign up form is displayed

  
  @signup
  Scenario: Register new user happy path
    Given mobile app is running
    And I click "Skip" button
    Then sign up form is displayed

    When I enter "1217104665" phone number
    And I click "Next" button at Signup form
    Then app asks for pin code

    When I enter "1245" pin code
    Then app asks to enter sms verification code
    