package UI_Selenium.step_defs;

import UI_Selenium.pages.LogInPage;
import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class QA_SectionTest {
    ScenarioContext context;

    public QA_SectionTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @Given("I navigate to login page")
    public void INavigateTo() {
        context.driver.get(ConfigReader.readProperty("projectURL", "src/test/resources/properties/configuration.properties"));
    }

    @When("I log in with valid email and password")
    public void iLogInWithValidAnd() {
        String email = ConfigReader.readProperty("email", "src/test/resources/properties/configuration.properties");
        String password = ConfigReader.readProperty("password", "src/test/resources/properties/configuration.properties");
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, password);
        context.selenium_utils.click(context.logInPage.signInbtn);
    }

    @And("I navigate to All Topics")
    public void iNavigateToAllTopics() {
        context.selenium_utils.click(context.allTopicsPage.alltopics_dash);
    }

    @Then("I verify each question contains a Question")
    public void iVerifyEachQuestionContainsAQuestion() {
        int count = 0;
        for (WebElement e : context.allTopicsPage.questions) {
            if (e.getText().length() > 0) {
                count++;
            }
        }
        Assert.assertTrue(count == context.allTopicsPage.questions.size());
        context.selenium_utils.logInfo("Each question field is not empty", true);
    }

    @And("I verify each question has an Answer section")
    public void iVerifyEachQuestionHasAnAnswerSection() {
        for (int i = 0; i < context.allTopicsPage.questions.size(); i++) {
            context.selenium_utils.moveIntoView(context.allTopicsPage.answerCount.get(i));
            context.selenium_utils.click(context.allTopicsPage.questions.get(i));
            Assert.assertTrue(context.allTopicsPage.answerSection.isDisplayed());
        }
    }

    @Then("I verify there is an Answer count for each question")
    public void iVerifyThereIsAnAnswerCountForEachQuestion() {
        //Verification option 1
        Assert.assertTrue(context.allTopicsPage.questions.size() == context.allTopicsPage.answerCount.size());
        //Verification option 2
        for(int i = 0; i < context.allTopicsPage.answerCount.size(); i++) {
            Assert.assertTrue(context.allTopicsPage.answerCount.get(i).isDisplayed());
            if(i < 3 || i > 87) {
                context.selenium_utils.moveIntoView(context.allTopicsPage.answerCount.get(i));
                context.selenium_utils.logInfo("Each question contains an Answer Count", true);
            }
        }
    }
}


