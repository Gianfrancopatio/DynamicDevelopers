package UI_Selenium.step_defs;

import io.cucumber.java.en.Then;

public class DosDontsTablePageTest {
    ScenarioContext context;

    public DosDontsTablePageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @Then("I verify Do's table exists")
    public void i_verify_do_s_table_exists() {
    }

    @Then("I verify Dont's table exists")
    public void i_verify_dont_s_table_exists() {
    }
}
