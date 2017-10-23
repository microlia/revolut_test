import cucumber.api.java.en.Given;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dina.vasileva on 23/10/2017.
 */
public class NewBeneficiaryStepDefinitions {

    @Given("mobile app is running")
    public void runApp() throws Throwable {
        assertTrue("This will succeed.", true);
    }
}
