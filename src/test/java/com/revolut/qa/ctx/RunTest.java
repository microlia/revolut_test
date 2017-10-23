package com.revolut.qa.ctx;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.*;

/**
 * Created by dina.vasileva on 23/10/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "src/test/resources/scenarios",
        glue = "com/revolut/qa"
)
public class RunTest {
}
