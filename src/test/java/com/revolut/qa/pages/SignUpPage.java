package com.revolut.qa.pages;

import org.openqa.selenium.By;
import static junit.framework.Assert.assertTrue;

/**
 * Created by dina.vasileva on 24/10/2017.
 */
public class SignUpPage extends BasePage {
    public SignUpPage(BasePage page) {
        super(page);
        this.ctx = page.ctx;
        this.driver = page.driver;
    }

    public void checkSignUpFormDisplayed() throws Throwable {
        assertTrue(driver.findElement(By.id(ctx.packageName + ":id/sign_phone_number_fragment")).isDisplayed());
    }

    public void enterPhoneNumber(String number) throws Throwable {
        driver.findElement(By.id(ctx.packageName + ":id/edit_phone_number")).sendKeys(number);
    }

    public void clickButton(String buttonTitle) {
        switch (buttonTitle) {
            case "Next":
                driver.findElement(By.id(ctx.packageName + ":id/signup_next")).click();
                break;
        }
    }
}
