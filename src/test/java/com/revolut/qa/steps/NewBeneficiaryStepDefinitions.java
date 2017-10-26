package com.revolut.qa.steps;

import com.revolut.qa.AndroidSetup;
import com.revolut.qa.pages.BasePage;
import com.revolut.qa.pages.SignUpPage;
import com.revolut.qa.pages.TutorialPage;
import java.util.List;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dina.vasileva on 23/10/2017.
 */
public class NewBeneficiaryStepDefinitions {
    public AndroidSetup ctx = new AndroidSetup();
    public NewBeneficiaryStepDefinitions(AndroidSetup ctx) {
        this.ctx = ctx;
        ctx.setNewBeneficiarySteps(this);
    }
    public BasePage page = new BasePage(ctx);
    private TutorialPage tutorialPage = new TutorialPage(page);
    private SignUpPage signUpPage = new SignUpPage(page);
    String account;
    String sCode;

    public NewBeneficiaryStepDefinitions getNewBeneficiaryStepDefinitions() throws Throwable {
        return this;
    }

    public void setPageSettings(BasePage page) throws Throwable{
        page.beneficiaryScenario = getNewBeneficiaryStepDefinitions();
        page.driver = tutorialPage.beneficiaryScenario.ctx.getDriver();
    }

    @Given("^mobile app is running$")
    public void mobile_app_is_running() throws Throwable {
        ctx.startDriver();
    }

    @Given("application was not installed before")
    public void checkAppIsNotInstalled() throws Throwable {
        assertTrue(!ctx.getDriver().isAppInstalled(ctx.packageName));
    }

    @Then("I see \"([^\"]*)\" tutorial title")
    public void checkTitleText(String expectedText) throws Throwable {
        setPageSettings(tutorialPage);
        tutorialPage.checkText(expectedText, "tutorial_title");
    }

    @Then("I see \"([^\"]*)\" tutorial subtitle")
    public void checkText(String expectedText) throws Throwable {
        setPageSettings(tutorialPage);
        tutorialPage.checkText(expectedText, "tutorial_subtitle");
    }

    @When("I click \"([^\"]*)\" button$")
    public void clickButton(String buttonCaption) throws Throwable {
        setPageSettings(tutorialPage);
        tutorialPage.clickButton(buttonCaption);
    }

    @Then("sign up form is displayed")
    public void checkSignUpFormDisplayed() throws Throwable {
        setPageSettings(signUpPage);
        signUpPage.checkSignUpFormDisplayed();
    }

    @When("I enter \"([^\"]*)\" phone number")
    public void enterPhoneNumber(String phoneNumber) throws Throwable {
        setPageSettings(signUpPage);
        signUpPage.enterPhoneNumber(phoneNumber);
    }

    @When("I click \"([^\"]*)\" button at Signup form")
    public void clickSignUpButton(String buttonCaption) throws Throwable {
        setPageSettings(signUpPage);
        signUpPage.clickButton(buttonCaption);
    }

    public List<String> convertStringToStringCollection(String text) {
        List<String> stringCollection = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            stringCollection.add(String.valueOf(text.charAt(i)));
        }
        return stringCollection;
    }

    @When("I enter \"([^\"]*)\" pin code")
    public void enterPinCode(String pinCode) throws Throwable {
        List<String> digits = convertStringToStringCollection(pinCode);

        for(String digit : digits) {
            signUpPage.clickDigitOnKeyboard(digit);
        }
    }

    @When("I click central bottom button")
    public void clickCentralButton() throws Throwable {
        signUpPage.clickCentralBottomButton();
    }

    @When("I click \"([^\"]*)\" menu item")
    public void chooseMenuItem(String menuItemName) throws Throwable {
        signUpPage.chooseMenuItem(menuItemName);
    }

    @When("I click \"([^\"]*)\" option")
    public void clickNamedOption(String optionName) throws Throwable {
        signUpPage.clickMenuOption(optionName);
    }

    @Then("I see \"([^\"]*)\" title")
    public void checkOptionGroupName(String optionGroupName) throws Throwable {
        signUpPage.checkOptionGroupNameDisplayed(optionGroupName);
    }

    @When("I choose \"([^\"]*)\" radio option")
    public void chooseRadioOption(String optionName) throws Throwable {
        signUpPage.chooseRadioOptionByName(optionName);
    }

    @When("I enter \"([^\"]*)\" account number")
    public void enterAccountNumber(String accountNumber) throws Throwable {
        account = accountNumber;
        signUpPage.enterAccountNumber(accountNumber);
    }

    @When("I enter \"([^\"]*)\" sort code")
    public void enterSortCode(String sortCode) throws Throwable {
        sCode = sortCode;
        signUpPage.enterSortCode(sortCode);
    }

    @Then("I see \"([^\"]*)\" <name> \"([^\"]*)\" confirmation")
    public void checkConfirmation(String part1, String part2) throws Throwable {
        signUpPage.checkConfirmationMessage(part1, part2);
    }

    @Then("I see newly created beneficiary at the top of beneficiary names")
    public void checkBeneficiaryIsCreated() throws Throwable {
        signUpPage.checkNewRowCreated("Account number: " + account, "Sort code: " + sCode);
    }
}
