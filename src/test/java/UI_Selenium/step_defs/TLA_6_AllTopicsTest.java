package UI_Selenium.step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class TLA_6_AllTopicsTest {
    ScenarioContext context;

    public TLA_6_AllTopicsTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @When("I log in with valid email {string} and password {string}")
    public void iLogInWithValidEmailAndPassword(String email, String password) {
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, password);
        context.selenium_utils.click(context.logInPage.signInbtn);
        context.selenium_utils.logInfo("I login using valid email: " + email + " and password: " + password, true);
    }

    @Then("I verify that All Topic dash is visible")
    public void iVerifyThatAllTopicDashIsVisible() {
        context.selenium_utils.highlightElement(context.allTopicsPage.alltopics_dash);
        Assert.assertTrue(context.allTopicsPage.alltopics_dash.isDisplayed());
        context.selenium_utils.logInfo("I verify AllTopics dash is displayed", true);
    }

    @And("I verify that All Topic dash is clickable")
    public void iVerifyThatAllTopicDashIsClickable() {
        context.selenium_utils.highlightElement(context.allTopicsPage.alltopics_dash);
        Assert.assertTrue(context.allTopicsPage.alltopics_dash.isEnabled());
        context.selenium_utils.logInfo("I verify that Alltopics dash is enabled", false);
    }

    @When("I click on Alltopics dashboard")
    public void iClickOnAlltopicsDashboard() {
        context.selenium_utils.click(context.allTopicsPage.alltopics_dash);
    }

    @And("I sendKey {string}")
    public void iSendKey(String question) {
        context.selenium_utils.sendKeys(context.allTopicsPage.search_Field, question);
        context.selenium_utils.logInfo("I sendKey: " + question + " in search field", true);

    }

    @When("I click {string} button")
    public void iClickButton(String searchBtn) {
        context.selenium_utils.click(context.allTopicsPage.search_Btn);
        context.selenium_utils.logInfo("I click " + searchBtn + "button", false);

    }

    @Then("I verify that AllTopic dashboad contains {string}")
    public void iVerifyThatAllTopicDashboadContains(String question) {
        context.selenium_utils.sleep(2000);
        Assert.assertEquals(question, context.allTopicsPage.search_result.get(0).getText());
        context.selenium_utils.logInfo("Alltopics dash contains " + question, true);

    }

    @Then("I verify that AllTopic dashboad does not contains {string}")
    public void iVerifyThatAllTopicDashboadDoesNotContains(String randomQuestion) {
        context.selenium_utils.sleep(2000);
        List<WebElement> list = context.allTopicsPage.search_result;
        Assert.assertEquals(list.size(), 0);
        context.selenium_utils.logInfo("Alltopics dash doesn't contain " + randomQuestion, true);
    }
    
}
