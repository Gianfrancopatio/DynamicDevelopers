package UI_Selenium.step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DosnDontsStatementsPageTest {
    ScenarioContext context;
    public DosnDontsStatementsPageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @When("I click on Add Do button")
    public void i_click_on_add_do_button() {
        Assert.assertTrue(context.dosnDontsStatementsPage.doAddButton.isDisplayed());

    }
}
