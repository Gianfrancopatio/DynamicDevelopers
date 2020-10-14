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

    List<String> questions = new ArrayList<>();
    @And("user capture questions from {string}")
    public void userCaptureQuestionsFrom(String arg0) {
        for (WebElement element : context.allTopicsPage.questions){
            questions.add(element.getText());
        }
    }
    @When("user navigate to main page")
    public void userNavigateToMainPage() {
        context.selenium_utils.click(context.allTopicsPage.logoBtn);
        context.selenium_utils.logInfo("user navigate to home page", true);
    }

    @Then("user verify that AllTopic dashboard contains question")
    public void userVerifyThatAllTopicDashboardContainsQuestion() {
        int count = 0;
        for (int i = 0;i < context.allTopicsPage.questions.size(); i++){
            for(int j = 0; j < questions.size(); j++){
                if (context.allTopicsPage.questions.get(i).getText().equals(questions.get(j))){
                    count ++;
                }
            }

        }
        Assert.assertEquals(count, questions.size());
        context.selenium_utils.logInfo("All topics dashboard contains question" , true);
    }
}
