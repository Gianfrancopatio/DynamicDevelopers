package UI_Selenium.step_defs;

import UI_Selenium.pages.TLA_6_AllTopicsPage;

import UI_Selenium.pages.LogInPage;
import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class QA_SectionTest {
    ScenarioContext context;

    public QA_SectionTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @Given("User navigates to login pages")
    public void INavigateTo() {
        context.driver.get(ConfigReader.readProperty("projectURL", "src/test/resources/properties/configuration.properties"));
    }

    @When("User logs in with valid email and password")
    public void iLogInWithValidAnd() {
        String email = ConfigReader.readProperty("email", "src/test/resources/properties/configuration.properties");
        String password = ConfigReader.readProperty("password", "src/test/resources/properties/configuration.properties");
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, password);
        context.selenium_utils.click(context.logInPage.signInbtn);
    }

    @And("User navigates to All Topics")
    public void iNavigateToAllTopics() {
        context.selenium_utils.click(context.allTopicsPage.alltopics_dash);
    }

    @Then("User verifies each question field is not empty")
    public void iVerifyEachQuestionContainsAQuestion() {
        int count = 0;
        for (int i = 0; i < context.allTopicsPage.questions.size(); i++) {
            context.selenium_utils.moveIntoView(context.allTopicsPage.questions.get(i));
            if (context.allTopicsPage.questions.get(i).getText().length() > 0) {
                String question = context.allTopicsPage.questions.get(i).getText();
                count++;
                if (i < 3 || i > context.allTopicsPage.questions.size() - 4)
                    context.selenium_utils.logInfo("Question is " + question, true);
            }
        }
        Assert.assertTrue(count == context.allTopicsPage.questions.size());
    }

    @And("User verifies each question has an Answer section")
    public void iVerifyEachQuestionHasAnAnswerSection() {
        for (int i = 0; i < context.allTopicsPage.questions.size(); i++) {
            context.selenium_utils.moveIntoView(context.allTopicsPage.answerCount.get(i));
            context.selenium_utils.click(context.allTopicsPage.questions.get(i));
            Assert.assertTrue(context.allTopicsPage.answerSection.isDisplayed());
            String question = context.allTopicsPage.questions.get(i).getText();
            if (i < 3 || i > context.allTopicsPage.questions.size() - 4) {
                context.selenium_utils.logInfo("Question " + question + " has an Answer section", true);
            }
        }
    }

    @And("User navigates to {string} page")
    public void userNavigatesTo(String topic) {
        String template = "//*[text()='%s']";
        String xpath = String.format(template, topic);
        context.selenium_utils.click(context.driver.findElement(By.xpath(xpath)));
    }

    @And("User clicks {string} button")
    public void userClicksButton(String button) {
        String template = "//*[text()='%s']";
        String xpath = String.format(template, button);
        context.selenium_utils.click(context.driver.findElement(By.xpath(xpath)));
    }

    @And("User enters {string} into the form")
    public void userEntersIntoTheForm(String question) {
        context.selenium_utils.sendKeys(context.allTopicsPage.questionForm, question);
    }

    @And("User clicks {string} link")
    public void userClicksLink(String link) {
        context.selenium_utils.click(context.allTopicsPage.linkQuestion);
    }

    @And("User inputs {string} into the form")
    public void userInputsIntoTheForm(String answer) {
        switch(answer) {
            case "Testing Answer Count 1":
                context.selenium_utils.sendKeys(context.allTopicsPage.answerForm, answer);
                break;
            case "Testing Answer Count 2":
                context.selenium_utils.sendKeys(context.allTopicsPage.answerForm, answer);
                break;
        }
    }

    @Then("User verifies there is an Answer count for each Question")
    public void iVerifyThereIsAnAnswerCountForEachQuestion() {
        for (int i = 0; i < context.allTopicsPage.answerCount.size(); i++) {
            Assert.assertTrue(context.allTopicsPage.answerCount.get(i).isDisplayed());
            if (i < 3 || i > context.allTopicsPage.questions.size() - 4) {
                String question = context.allTopicsPage.questions.get(i).getText();
                context.selenium_utils.moveIntoView(context.allTopicsPage.answerCount.get(i));
                context.selenium_utils.logInfo("For " + question + " the Answer Count is Displayed", true);
            }
        }
    }

    @And("User verifies the answer count is {string} for {string}")
    public void userVerifiesTheAnswerCountIsFor(String answCount, String question) {
        context.selenium_utils.click(context.allTopicsPage.questions.get(0));
        String count = context.allTopicsPage.answerCount.get(0).getText();
        Assert.assertTrue(count.equals(answCount));
        context.selenium_utils.logInfo("Question " + question + " has " + count + " answers and the Answer Counter displays " + answCount, true);
    }
}



