package ctx;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dina.vasileva on 22/10/2017.
 */
public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("/Users/dina.vasileva/Downloads");
        File app = new File(appDir, "Revolut_qa_4.3.0.237.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }


    @Before
    public void before(Scenario scenario) throws Throwable {
        prepareAndroidForAppium();
        driver.launchApp();
    }

    @After
    public void after(Scenario scenario) throws Throwable {
        driver.closeApp();
    }
}
