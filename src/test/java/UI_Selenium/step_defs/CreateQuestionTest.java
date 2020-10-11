package UI_Selenium.step_defs;


import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CreateQuestionTest {
    ScenarioContext context;

    public CreateQuestionTest(
            ScenarioContext scenarioContext) {
        context = scenarioContext;
    }


    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        context.driver.get(ConfigReader.readProperty(
                "projectURL",
                "src/test/resources/properties/configuration.properties"));

    }

    @When("User log in with valid email and password")
    public void userLogInWithValidEmailAndPassword() {
        String email = ConfigReader.readProperty("email", "src/test/resources/properties/configuration.properties");
        String password = ConfigReader.readProperty("password", "src/test/resources/properties/configuration.properties");
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, password);
        context.selenium_utils.click(context.logInPage.signInbtn);

    }

    @And("User can navigate to Coding Dashboard")
    public void userCanNavigateToCodingDashboard() {
        context.selenium_utils.click(context.createQuestionPage.SelectCoding);


    }

    @Then("User clicks on yellow icon")
    public void userClicksOnYellowIcon() {
        context.selenium_utils.click(context.createQuestionPage.clickButton);
    }

    @Then("User can input NEW questions under yellow icon")
    public void userCanInputNEWQuestionsUnderYellowIcon() throws InterruptedException {
        context.selenium_utils.click(context.createQuestionPage.EnterQA);


        Thread.sleep(2000);
    }


    @Then("User can type question {string}")
    public void userCanTypeQuestion(String arg0) throws InterruptedException {
        Thread.sleep(200);
        context.selenium_utils.waitForVisibility(context.createQuestionPage.EnterQA);
        context.selenium_utils.sendKeys(context.createQuestionPage.EnterQA, arg0);
        context.selenium_utils.click(context.createQuestionPage.EnterQA);
    }

    @When("User click enter for question")
    public void userClickEnterForQuestion() {
        context.selenium_utils.click(context.createQuestionPage.click_enter);
    }


    @And("Time stamp is verified")
    public void timeStampIsVerified() {
        Assert.assertTrue(context.createQuestionPage.DisplayStamp.isDisplayed());
    }


}
