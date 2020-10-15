package UI_Selenium.step_defs;


import UI_Selenium.pages.TLA_6_AllTopicsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
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
        context.selenium_utils.logInfo("I login using valid email: " + email + " and password: " + password, true);
        context.selenium_utils.click(context.logInPage.signInbtn);

    }

    @Then("I verify that All Topic dash is visible")
    public void iVerifyThatAllTopicDashIsVisible() {
        context.selenium_utils.highlightElement(context.allTopicsPage.alltopics_dash);
        context.selenium_utils.sleep(500);
        Assert.assertTrue(context.allTopicsPage.alltopics_dash.isDisplayed());
        context.selenium_utils.logInfo("I verify AllTopics dash is displayed", true);

    }

    @And("I verify that All Topic dash is clickable")
    public void iVerifyThatAllTopicDashIsClickable() {
        context.selenium_utils.highlightElement(context.allTopicsPage.alltopics_dash);
        Assert.assertTrue(context.allTopicsPage.alltopics_dash.isEnabled());
        context.selenium_utils.logInfo("I verify that AllTopics dash is enabled", false);
    }


    List<String> questions = new ArrayList<>();
    @And("user capture questions from {string}")
    public void userCaptureQuestionsFrom(String dashboard) {
            int listSize = context.allTopicsPage.questions.size();
            if (listSize < 3){
                for (int i = 0;i < context.allTopicsPage.questions.size(); i++){
                    context.selenium_utils.sleep(500);
                    questions.add(context.allTopicsPage.questions.get(i).getText());
                }
            }else{
                for (int i = 0; i < 3 ; i++){
                    context.selenium_utils.sleep(500);
                    questions.add(context.allTopicsPage.questions.get(i).getText());
                }
            }
            context.selenium_utils.logInfo("capturing question form " + dashboard, true);
    }
    @When("user navigate to main page")
    public void userNavigateToMainPage() {
        context.selenium_utils.click(context.allTopicsPage.logoBtn);
        context.selenium_utils.logInfo("user navigate to home page", true);
    }

    @Then("user verify that AllTopic dashboard contains questions from {string}")
    public void userVerifyThatAllTopicDashboardContainsQuestionsFrom(String dashboard) {
        for (int i = 0; i < questions.size(); i++){
            context.selenium_utils.sleep(500);
            String xPath = String.format(TLA_6_AllTopicsPage.questionXpath,questions.get(i));
            WebElement element = context.driver.findElement(By.xpath(xPath));
            context.selenium_utils.moveIntoView(element);
            Assert.assertTrue(element.isDisplayed());
            context.selenium_utils.logInfo("All topics dash contains | " + questions.get(i)+ " | from" + dashboard, true);
        }
    }

    @Then("user verify that AllTopic dashboard contains {string} from {string}")
    public void userVerifyThatAllTopicDashboardContainsFrom(String question, String dashboard) {
            context.selenium_utils.sleep(500);
            String xPath = String.format(TLA_6_AllTopicsPage.questionXpath,question);
            WebElement element = context.driver.findElement(By.xpath(xPath));
            context.selenium_utils.moveIntoView(element);
            Assert.assertTrue(element.isDisplayed());
            context.selenium_utils.logInfo("All topics dash contains | " + question+ " | from" + dashboard, true);

    }
}
