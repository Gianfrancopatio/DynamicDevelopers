package UI_Selenium.step_defs;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        context.selenium_utils.sleep(500);
        questions = context.allTopicsPage.convertToList(context.allTopicsPage.questions);
        context.selenium_utils.logInfo("capturing question form " + dashboard, true);
    }
    @When("user navigate to main page")
    public void userNavigateToMainPage() {
        context.selenium_utils.click(context.allTopicsPage.logoBtn);
        context.selenium_utils.logInfo("user navigate to home page", true);
    }

    @Then("user verify that AllTopic dashboard contains questions from {string}")
    public void userVerifyThatAllTopicDashboardContainsQuestionsFrom(String dashboard) {
        int count = 0;
        context.selenium_utils.sleep(1000);
        List<String> questionsList = context.allTopicsPage.convertToList(context.allTopicsPage.questions);
//        System.out.println(questionsList.size());
        for (int i =0; i < questionsList.size(); i++){
            for(int j = 0; j < questions.size(); j++){
                if (questionsList.get(i).equals(questions.get(j))){
                    context.selenium_utils.moveIntoView(context.allTopicsPage.questions.get(i));
                    context.selenium_utils.logInfo("All topics dash contains |"+ questionsList.get(i) + "| from "+ dashboard, true);
                    count ++;
                }
            }
        }
        Assert.assertEquals(count, questions.size());
    }
}
