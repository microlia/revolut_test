package com.revolut.qa.pages;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

/**
 * Created by dina.vasileva on 24/10/2017.
 */
public class TutorialPage extends BasePage {
    public TutorialPage(BasePage page) {
        super(page);
        this.ctx = page.ctx;
        this.driver = page.driver;
    }

    public void clickButton(String buttonTitle) {
        switch (buttonTitle) {
            case "Continue":
                driver.findElement(By.id(ctx.packageName + ":id/next_button")).click();
                break;
            case "Skip":
                driver.findElement(By.id(ctx.packageName + ":id/header_next")).click();
                break;
            case "Next":
                driver.findElement(By.id(ctx.packageName + ":id/button_next")).click();
                break;
            case "Done":
                driver.findElement(By.id(ctx.packageName + ":id/operation_status_button")).click();
        }
    }
}
