package UI_Selenium.step_defs;

import UI_Selenium.pages.SessionExpiresPage;
import UI_Selenium.ui_utils.Selenium_utils;
import common_utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SessionExpiresPageTest {
    ScenarioContext context;

    public SessionExpiresPageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @Given("Website opening")
    public void websiteOpening() {
        context.driver.get(ConfigReader.readProperty
                ("projectURL","src/test/resources/properties/configuration.properties"));
    }
    @When("I log in with email {string} and password {string}")
    public void iLogInWithEmailAndPassword(String arg0, String arg1) {
        context.selenium_utils.sendKeys(context.sessionExpiresPage.email4,arg0);
        context.selenium_utils.sendKeys(context.sessionExpiresPage.password4, arg1);
        context.selenium_utils.click(context.sessionExpiresPage.signIn4);
    }


    @Then("user signs out by pressing welcome button")
    public void userSignsOutByPressingWelcomeButton() {
        context.selenium_utils.click(context.sessionExpiresPage.welcomeBtn);
    }

    @Then("user clicks on sign out")
    public void userClicksOnSignOut() {
        context.selenium_utils.click(context.sessionExpiresPage.signOutBtn);
    }
    @Then("I verify session is expired")
    public void i_verify_session_is_expired() {
        Assert.assertTrue(context.sessionExpiresPage.createAccountBtn.isDisplayed());

    }
}


