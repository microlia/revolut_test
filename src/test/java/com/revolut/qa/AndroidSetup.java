package com.revolut.qa;

import com.revolut.qa.steps.NewBeneficiaryStepDefinitions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dina.vasileva on 22/10/2017.
 */
public class AndroidSetup {
    protected AndroidDriver driver;
    private NewBeneficiaryStepDefinitions newBeneficiarySteps;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    public static String packageName = "com.revolut.revolut.test";

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("/Users/dina.vasileva/Downloads");
        File app = new File(appDir, "Revolut_qa_4.3.0.237.apk");

        //TODO: move all settings to properties file
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"test");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability("avd","test");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.revolut.revolut.test");
        capabilities.setCapability("appActivity", "com.revolut.ui.login.pin.LoginActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("clearSystemFiles", true);
    }

    public void startDriver() throws Throwable {
        prepareAndroidForAppium();
        driver =  new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void removeApp(String bundleId) throws Throwable {
        startDriver();
        if (getDriver().isAppInstalled(bundleId)) {
            driver.removeApp(bundleId);
        }
    }


    @Before
    public void before() throws Throwable {
        removeApp("com.revolut.revolut.test");
    }

    @After
    public void after() throws Throwable {
//        driver.closeApp();
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setNewBeneficiarySteps(NewBeneficiaryStepDefinitions newBeneficiarySteps) {
        this.newBeneficiarySteps = newBeneficiarySteps;
    }
}
