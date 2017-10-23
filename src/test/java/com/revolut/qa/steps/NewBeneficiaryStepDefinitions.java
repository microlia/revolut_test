package com.revolut.qa.steps;

import com.revolut.qa.AndroidSetup;
import cucumber.api.java.en.Given;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dina.vasileva on 23/10/2017.
 */
public class NewBeneficiaryStepDefinitions {
    private AndroidSetup androidSetup;
    public NewBeneficiaryStepDefinitions(AndroidSetup androidSetup) {
        this.androidSetup = androidSetup;
        androidSetup.setNewBeneficiarySteps(this);
    }

    @Given("^mobile app is running$")
    public void mobile_app_is_running() throws Throwable {
        assertTrue(!androidSetup.getDriver().equals(null));
    }
}
