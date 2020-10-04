package UI_Selenium.step_defs;

import UI_Selenium.pages.SessionExpiresPage;
import UI_Selenium.ui_utils.Selenium_utils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SessionExpiresPageTest {
    ScenarioContext context;

    public SessionExpiresPageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @Then("user signs out")
    public void user_signs_out() {
        context.selenium_utils.click(context.sessionExpiresPage.welcomeBtn);
        context.selenium_utils.click(context.sessionExpiresPage.signOutBtn);

    }

    @Then("I verify session is expired")
    public void i_verify_session_is_expired() {
        Assert.assertTrue(context.sessionExpiresPage.createAccountBtn.isDisplayed());

    }

}
