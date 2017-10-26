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

  
  @signup @add_beneficiary
  Scenario: Register new beneficiary
    Given mobile app is running
    And I click "Skip" button
    Then sign up form is displayed

    When I enter "1217104665" phone number
    And I click "Next" button at Signup form
    And I enter "1245" pin code
    And I click "Not now" button at Signup form
    And I click central bottom button
    And I click "To bank account" menu item
    And I click "Skip" button
    And I click "Add a new beneficiary" option
    Then I see "Choose transfer type" title

    When I choose "To myself" radio option
    And I click "Next" button
    Then I see "Choose country and currency" title

    When I click "Next" button
    Then I see "Fill into account details" title

    When I enter "12345678" account number
    And I enter "123456" sort code
    And I click "Next" button
    Then I see "Beneficiary" <name> "was successfully created" confirmation

    When I click "Done" button
    Then I see newly created beneficiary at the top of beneficiary names

