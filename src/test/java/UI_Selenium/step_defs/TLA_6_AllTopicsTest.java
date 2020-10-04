package UI_Selenium.step_defs;


import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TLA_6_AllTopicsTest {
    ScenarioContext context;

    public TLA_6_AllTopicsTest(ScenarioContext scenarioContext){
        context = scenarioContext;
    }

    @Given("I open {string}")
    public void iOpen(String url) {
        context.driver.get(ConfigReader.readProperty("url", "src/test/resources/properties/configuration.properties"));


    }

    @When("I log in with valid email {string} and password {string}")
    public void iLogInWithValidEmailAndPassword(String email, String password) {
        context.selenium_utils.sendKeys(context.allTopicsPage.email_field,email);
        context.selenium_utils.sendKeys(context.allTopicsPage.password_field, password);
        context.selenium_utils.click(context.allTopicsPage.signIn_Btn);


    }

    @Then("I verify that All Topic dash is visible")
    public void iVerifyThatAllTopicDashIsVisible() {
        Assert.assertTrue(context.allTopicsPage.alltopics_dash.isDisplayed());
        
    }

    @And("I verify that All Topic dash is clickable")
    public void iVerifyThatAllTopicDashIsClickable() {
        Assert.assertTrue(context.allTopicsPage.alltopics_dash.isEnabled());
    }

    @When("I click on Alltopics dashboard")
    public void iClickOnAlltopicsDashboard() {
        context.selenium_utils.click(context.allTopicsPage.alltopics_dash);
    }

    @And("I sendKey {string} from {string}")
    public void iSendKeyFrom(String arg0, String arg1) {
        
    }

    @When("I click {string} button")
    public void iClickButton(String arg0) {
        
    }

    @Then("I verify that AllTopic dashboad contains {string}")
    public void iVerifyThatAllTopicDashboadContains(String arg0) {
        
    }

    @Then("I verify that AllTopic dashboad does not contains {string}")
    public void iVerifyThatAllTopicDashboadDoesNotContains(String arg0) {
    }
}
