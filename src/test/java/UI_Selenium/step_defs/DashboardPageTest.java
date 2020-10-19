package UI_Selenium.step_defs;

import UI_Selenium.pages.DashboardPage;
import UI_Selenium.pages.LogInPage;
import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPageTest {
    ScenarioContext context;

    public DashboardPageTest(ScenarioContext scenarioContext) {
        this.context = scenarioContext;
    }

    //Pavel
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
        context.selenium_utils.click(context.dashboardPage.alltopics_dash);
    }

    @Then("User verifies each question field is not empty")
    public void iVerifyEachQuestionContainsAQuestion() {
        int count = 0;
        for (int i = 0; i < context.dashboardPage.questions.size(); i++) {
            context.selenium_utils.moveIntoView(context.dashboardPage.questions.get(i));
            if (context.dashboardPage.questions.get(i).getText().length() > 0) {
                String question = context.dashboardPage.questions.get(i).getText();
                count++;
                if (i < 3 || i > context.dashboardPage.questions.size() - 4)
                    context.selenium_utils.logInfo("Question is " + question, true);
            }
        }
        Assert.assertTrue(count == context.dashboardPage.questions.size());
    }

    @And("User verifies each question has an Answer section")
    public void iVerifyEachQuestionHasAnAnswerSection() {
        for (int i = 0; i < context.dashboardPage.questions.size(); i++) {
            context.selenium_utils.moveIntoView(context.dashboardPage.answerCount.get(i));
            context.selenium_utils.click(context.dashboardPage.questions.get(i));
            Assert.assertTrue(context.dashboardPage.answerSection.isDisplayed());
            String question = context.dashboardPage.questions.get(i).getText();
            if (i < 3 || i > context.dashboardPage.questions.size() - 4) {
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
        context.selenium_utils.sendKeys(context.dashboardPage.questionForm, question);
    }

    @And("User clicks {string} link")
    public void userClicksLink(String link) {
        context.selenium_utils.click(context.dashboardPage.linkQuestion);
    }

    @And("User inputs {string} into the form")
    public void userInputsIntoTheForm(String answer) {
        switch (answer) {
            case "Testing Answer Count 1":
                context.selenium_utils.sendKeys(context.dashboardPage.answerForm, answer);
                break;
            case "Testing Answer Count 2":
                context.selenium_utils.sendKeys(context.dashboardPage.answerForm, answer);
                break;
        }
    }

    @Then("User verifies there is an Answer count for each Question")
    public void iVerifyThereIsAnAnswerCountForEachQuestion() {
        for (int i = 0; i < context.dashboardPage.answerCount.size(); i++) {
            Assert.assertTrue(context.dashboardPage.answerCount.get(i).isDisplayed());
            if (i < 3 || i > context.dashboardPage.questions.size() - 4) {
                String question = context.dashboardPage.questions.get(i).getText();
                context.selenium_utils.moveIntoView(context.dashboardPage.answerCount.get(i));
                context.selenium_utils.logInfo("For " + question + " the Answer Count is Displayed", true);
            }
        }
    }

    @And("User verifies the answer count is {string} for {string}")
    public void userVerifiesTheAnswerCountIsFor(String answCount, String question) {
        context.selenium_utils.click(context.dashboardPage.questions.get(0));
        String count = context.dashboardPage.answerCount.get(0).getText();
        Assert.assertTrue(count.equals(answCount));
        context.selenium_utils.logInfo("Question " + question + " has " + count + " answers and the Answer Counter displays " + answCount, true);
    }
    // End of Pavel's steps

    /**
     * ----------------------------------/-Muneer-started/------------------------------------
     */
    /**
     * verify visibility of dashboard
     * TlA-6 All Topics dash
     *
     * @author: Muneer
     */
    @Then("I verify that {string} dash is visible")
    public void iVerifyThatDashIsVisible(String dashboard) {
        context.selenium_utils.sleep(500);
        String xPath = String.format(LogInPage.buttonXpath, dashboard);
        org.testng.Assert.assertTrue(context.driver.findElement(By.xpath(xPath)).isDisplayed());
        context.selenium_utils.logInfo("Dash is displayed: " + dashboard, true);
    }

    /**
     * verify dashboard is enable
     * TlA-6 All Topics dash
     *
     * @author: Muneer
     */
    @And("I verify that {string} dash is clickable")
    public void iVerifyThatDashIsClickable(String dashboard) {
        String xPath = String.format(LogInPage.buttonXpath, dashboard);
        org.testng.Assert.assertTrue(context.driver.findElement(By.xpath(xPath)).isEnabled());
        context.selenium_utils.logInfo("Dash is enabled: " + dashboard, false);

    }

    /**
     * capture 3 first question from dashboard
     * TlA-6 All Topics dash
     *
     * @author: Muneer
     */
    List<String> questions = new ArrayList<>();

    @And("user capture questions from {string}")
    public void userCaptureQuestionsFrom(String dashboard) {
        for (int i = 0; i < context.dashboardPage.questions.size(); i++) {
            context.selenium_utils.sleep(500);
            questions.add(context.dashboardPage.questions.get(i).getText());
            if (i == 2) {
                break;
            }
        }
        context.selenium_utils.logInfo("capturing question form " + dashboard, true);
    }

    /**
     * Navigate to main page
     * TlA-6 All Topics dash
     *
     * @author: Muneer
     */
    @When("user navigate to main page")
    public void userNavigateToMainPage() {
        context.selenium_utils.click(context.dashboardPage.logoBtn);
        context.selenium_utils.logInfo("user navigate to home page", true);
    }

    /**
     * verify All topics dash contains question form other dashboards
     * TlA-6 All Topics dash
     *
     * @author: Muneer
     */
    @Then("user verify that AllTopic dashboard contains questions from {string}")
    public void userVerifyThatAllTopicDashboardContainsQuestionsFrom(String dashboard) {
        for (int i = 0; i < questions.size(); i++) {
//            context.selenium_utils.sleep(500);
            String xPath = String.format(DashboardPage.questionXpath, questions.get(i));
            WebElement element = context.driver.findElement(By.xpath(xPath));
            context.selenium_utils.moveIntoView(element);
            org.testng.Assert.assertTrue(element.isDisplayed());
            context.selenium_utils.logInfo("All topics dash contains | " + questions.get(i) + " | from" + dashboard, true);
        }
    }

    /**
     * verify All Topics dash contains specific question
     * TlA-6 All Topics dash
     *
     * @author: Muneer
     */
    @Then("user verify that AllTopic dashboard contains {string} from {string}")
    public void userVerifyThatAllTopicDashboardContainsFrom(String question, String dashboard) {
//        context.selenium_utils.sleep(500);
        String xPath = String.format(DashboardPage.questionXpath, question);
        WebElement element = context.driver.findElement(By.xpath(xPath));
        context.selenium_utils.moveIntoView(element);
        org.testng.Assert.assertTrue(element.isDisplayed());
        context.selenium_utils.logInfo("All topics dash contains | " + question + " | from" + dashboard, true);

    }
    /**
     * ----------------------------------/-Muneer-ended/------------------------------------
     */


    /**
     * CreateQuestion- TLA 7- Juan
     */

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

        context.selenium_utils.logInfo("login credentials were accepted", true);

    }

    @And("User can navigate to Coding Dashboard")
    public void userCanNavigateToCodingDashboard() {
        context.selenium_utils.click(context.dashboardPage.SelectCoding);
        context.selenium_utils.logInfo("Coding dashboard window open", true);


    }

    @Then("User clicks on yellow icon")
    public void userClicksOnYellowIcon() {
        context.selenium_utils.click(context.dashboardPage.clickButton);
        context.selenium_utils.logInfo("Icon was clickable successfully", true);

    }

    @Then("User can input NEW questions under yellow icon")
    public void userCanInputNEWQuestionsUnderYellowIcon() throws InterruptedException {
        context.selenium_utils.click(context.dashboardPage.EnterQA);
        context.selenium_utils.logInfo("Was able to input question in bar", true);



    }


    @Then("User can type question {string}")
    public void userCanTypeQuestion(String arg0) throws InterruptedException {
        Thread.sleep(200);
        context.selenium_utils.waitForVisibility(context.dashboardPage.EnterQA);
        context.selenium_utils.sendKeys(context.dashboardPage.EnterQA, arg0);
        context.selenium_utils.click(context.dashboardPage.EnterQA);
        context.selenium_utils.logInfo("Question was accepted ", true);
    }

    @When("User click enter for question")
    public void userClickEnterForQuestion() {
        context.selenium_utils.click(context.dashboardPage.click_enter);
        context.selenium_utils.logInfo("Was able to enter question", true);
    }


    @And("Time stamp is verified")
    public void timeStampIsVerified() {
        Assert.assertTrue(context.dashboardPage.DisplayStamp.isDisplayed());
        context.selenium_utils.logInfo("Question displayed with stamp detail ", true);
    }

/**
 * ----------------------End- Juan-------------------------------------------------------
 */
}


