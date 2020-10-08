package UI_Selenium.step_defs;

import common_utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class DosnDontsStatementsPageTest {
    ScenarioContext context;
    public DosnDontsStatementsPageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;


    }
    @Given("Starting Website")
    public void startingWebsite() {
        context.driver.get(ConfigReader.readProperty
                ("projectURL","src/test/resources/properties/configuration.properties"));
    }
//    @When("I log in with email {string} and password {string}")
//    public void iLogInWithEmailAndPassword(String arg0, String arg1) {
//        context.selenium_utils.sendKeys(context.dosnDontsStatementsPage.email5, arg0);
//        context.selenium_utils.sendKeys(context.dosnDontsStatementsPage.password5, arg1);
//        context.selenium_utils.click(context.dosnDontsStatementsPage.signIn5);
//
//    }

// Do Table
    @When("I click on Add Do button")
    public void i_click_on_add_do_button()  {
        context.selenium_utils.sleep(5000);
        context.selenium_utils.moveIntoView(context.dosnDontsStatementsPage.doAddButton);

        context.selenium_utils.click(context.dosnDontsStatementsPage.doAddButton);

    }
    @Then("I sendKeys {string} and I verify it")
    public void iSendKeysAndIVerifyIt(String arg0) {
        context.selenium_utils.sendKeys(context.dosnDontsStatementsPage.textBox, arg0);
    }

    @When("I click enter button to enter new statement")
    public void iClickButtonToEnterNewStatement() {
        context.selenium_utils.click(context.dosnDontsStatementsPage.submitButton);
    }

    @Then("I verify that new statements appear at the bottom of the do table")
    public void iVerifyThatNewStatementsAppearAtTheBottomOfTheDoTable() {
        Assert.assertTrue(context.dosnDontsStatementsPage.doStatement.isDisplayed());

    }


// Don't Table

    @When("I click on Add Don't button")
    public void i_click_on_add_don_t_button() {
        context.selenium_utils.click(context.dosnDontsStatementsPage.dontAddButton);


    }
    @Then("I sendKey {string} and I verify it")
    public void i_send_key_and_i_verify_it(String string) {
        context.selenium_utils.sendKeys(context.dosnDontsStatementsPage.textBoxEntry, string);

    }

    @When("I click enter button to enter")
    public void iClickEnterButtonToEnter() {
        context.selenium_utils.click(context.dosnDontsStatementsPage.submitButton1);
    }


    @Then("I verify that new statements appear at the bottom of the don't table")
    public void iVerifyThatNewStatementsAppearAtTheBottomOfTheDonTTable() {
        Assert.assertTrue(context.dosnDontsStatementsPage.dontsStatement.isDisplayed());
    }



}
