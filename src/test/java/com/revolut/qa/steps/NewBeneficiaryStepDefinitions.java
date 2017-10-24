package com.revolut.qa.steps;

import com.revolut.qa.AndroidSetup;
import com.revolut.qa.pages.BasePage;
import com.revolut.qa.pages.SignUpPage;
import com.revolut.qa.pages.TutorialPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

    @When("I click \"([^\"]*)\" button")
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
}
