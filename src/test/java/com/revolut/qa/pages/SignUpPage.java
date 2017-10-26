package com.revolut.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertEquals;
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
        driver.findElement(By.id(ctx.packageName + ":id/uic_edit_phone_number")).click();
        driver.findElement(By.id(ctx.packageName + ":id/uic_edit_phone_number")).sendKeys(number);
    }

    public void clickButton(String buttonTitle) {
        switch (buttonTitle) {
            case "Next":
                driver.findElement(By.id(ctx.packageName + ":id/signup_next")).click();
                break;
            case "Allow contact access":
                driver.findElement(By.id(ctx.packageName + ":id/action_button")).click();
                break;
            case "Not now":
                driver.findElement(By.id(ctx.packageName + ":id/uic_header_next")).click();
        }
    }

    public void clickDigitOnKeyboard(String digit) throws Throwable {
        driver.findElement(By.id(ctx.packageName+":id/button_" + digit)).click();
    }

    public void clickCentralBottomButton() throws Throwable {
        driver.findElement(By.id(ctx.packageName + ":id/button_transfer")).click();
    }

    public void chooseMenuItem(String menuItemName) throws Throwable {
        driver.findElement(By.xpath(String.format("//*[@text=\"%s\"]", menuItemName))).click();
    }

    public void clickMenuOption(String optionName) throws Throwable {
        switch (optionName) {
            case "Add a new beneficiary":
                driver.findElementById("list_recycler_view").findElements(By.className("android.widget.RelativeLayout")).get(0).click();
                break;
        }
    }

    public void checkOptionGroupNameDisplayed(String optionGroupName) throws Throwable {
        assertTrue(optionGroupName, driver.findElement(By.xpath(String.format("//*[@text=\"%s\"]", optionGroupName))).isDisplayed());
    }

    public void chooseRadioOptionByName(String optionName) throws Throwable {
        driver.findElement(By.xpath(String.format("//*[@text=\"%s\"]", optionName))).click();
    }

    public void enterAccountNumber(String accountNumber) throws Throwable {
        WebElement element =  driver.findElement(By.id(ctx.packageName + ":id/server_field_0"));
        element.click();
        element.sendKeys(accountNumber);
        driver.hideKeyboard();
    }

    public void enterSortCode(String sortCode) throws Throwable {
        WebElement element = driver.findElement(By.id(ctx.packageName + ":id/server_field_1"));
        element.click();
        element.sendKeys(sortCode);
        driver.hideKeyboard();

    }

    public void checkConfirmationMessage(String part1, String part2) throws Throwable {
        String message = driver.findElement(By.id(ctx.packageName + ":id/operation_state_title")).getText();
        assertTrue(message.contains(part1) && message.contains(part2));
    }

    public void checkNewRowCreated(String accountNumber, String sortCode) throws Throwable {
        WebElement element = driver.findElementById("list_recycler_view")
                .findElements(By.className("android.widget.RelativeLayout")).get(1)
                .findElement(By.className("android.widget.LinearLayout"));

        String actualAccountNumber = element.findElement(By.id("item_subtitle1")).getText();
        assertEquals(accountNumber, actualAccountNumber);

        String actualSortCode = element.findElement(By.id("item_subtitle2")).getText();
        assertEquals(sortCode, actualSortCode);
    }
}
