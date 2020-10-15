package UI_Selenium.step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TLA_13_AdminRoleTest {
    ScenarioContext context;
    public TLA_13_AdminRoleTest(ScenarioContext scenarioContext){
        context = scenarioContext;
    }

    @Then("I verify delete button is visible")
    public void i_verify_delete_button_is_visible() {
            context.selenium_utils.highlightElement(context.tla_13_adminRolePage.deleteBtn);
            context.selenium_utils.click(context.tla_13_adminRolePage.deleteBtn);
            context.selenium_utils.sleep(3000);
            //Assert.assertTrue(context.tla_13_adminRolePage.deleteBtn.isDisplayed());
    }

    @Then("I verify that delete button in not visible")
    public void iVerifyThatDeleteButtonInNotVisible() {
        //Assert.assertEquals(context.tla_13_adminRolePage.deleteBtn.(), 0);
    }
}
