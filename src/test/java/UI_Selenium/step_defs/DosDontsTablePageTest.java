package UI_Selenium.step_defs;

import common_utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DosDontsTablePageTest {
    ScenarioContext context;

    public DosDontsTablePageTest(ScenarioContext scenarioContext) {

        context = scenarioContext;
    }
    @Given("I open website")
    public void i_open_website() {
        context.driver.get(ConfigReader.readProperty
                ("projectURL","src/test/resources/properties/configuration.properties"));
    }
    @When("I log on with email {string} and password {string}")
    public void i_log_on_with_email_and_password(String string, String string2) {
        context.selenium_utils.sendKeys(context.dosDontsTablePage.email15,string);
        context.selenium_utils.sendKeys(context.dosDontsTablePage.password15, string2);
        context.selenium_utils.click(context.dosDontsTablePage.signIn15);
        context.selenium_utils.logInfo("Logging in with valid credentials; email: " + string + " password: " + string2, true);
    }



        @Then("I verify Do's table exists")
    public void i_verify_do_s_table_exists() {
        context.selenium_utils.moveIntoView(context.dosDontsTablePage.doTable);
        Assert.assertTrue(context.dosDontsTablePage.doTable.isDisplayed());
        Assert.assertTrue(context.dosDontsTablePage.doTable1.isDisplayed());
        context.selenium_utils.logInfo("Verifying Do's Table exists", true);
    }

    @Then("I verify Dont's table exists")
    public void i_verify_dont_s_table_exists() {
        context.selenium_utils.moveIntoView(context.dosDontsTablePage.dontsTable);
        Assert.assertTrue(context.dosDontsTablePage.dontsTable.isDisplayed());
        Assert.assertTrue(context.dosDontsTablePage.dontsTable1.isDisplayed());
        context.selenium_utils.logInfo("Verifying Dont's Table exists", true);
    }
}
