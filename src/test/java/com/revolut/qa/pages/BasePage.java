package com.revolut.qa.pages;

import com.revolut.qa.AndroidSetup;
import com.revolut.qa.steps.NewBeneficiaryStepDefinitions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static junit.framework.Assert.assertEquals;

/**
 * Created by dina.vasileva on 24/10/2017.
 */
public class BasePage {
    public AndroidDriver driver;
    public AndroidSetup ctx;
    public NewBeneficiaryStepDefinitions beneficiaryScenario;

    public BasePage(AndroidSetup setup) {
        this.ctx = setup;
        this.driver = setup.getDriver();
    }

    public BasePage(BasePage basePage) {
        this.driver = basePage.driver;
        this.ctx = getSetup(basePage);
    }

    public AndroidSetup getSetup(BasePage basePage) {
        return basePage.ctx;
    }

    public void checkText(String expectedTitle, String elementId) {
        String title = driver.findElement(By.id(ctx.packageName + ":id/"+elementId)).getText();
        System.out.println("Text: " + title);
        assertEquals(expectedTitle, title);
    }
}
