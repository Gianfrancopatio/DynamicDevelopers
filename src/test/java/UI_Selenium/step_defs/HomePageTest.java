package UI_Selenium.step_defs;

import UI_Selenium.pages.HomePage;
import UI_Selenium.pages.LogInPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePageTest {
    ScenarioContext context;
    Faker faker = new Faker();
    String topic = faker.animal().name();
    public HomePageTest(ScenarioContext scenarioContext)
    {
        this.context = scenarioContext;
    }

    //Best TLA-02

    @When("User create new dashboard name with {string}")
    public void userCreateNewDashboardNameWith(String name) {

        switch (name.toLowerCase()) {
            case "newtopicname":
                context.selenium_utils.highlightElement(context.homePage.newDashboardAdd);
                context.selenium_utils.sendKeys(context.homePage.newDashboardAdd, topic);
                break;
            case "admintest":
                context.selenium_utils.highlightElement(context.homePage.newDashboardAdd);
                context.selenium_utils.sendKeys(context.homePage.newDashboardAdd, name);
                break;
            case "existingtopicname":
                context.selenium_utils.highlightElement(context.homePage.newDashboardAdd);
                context.selenium_utils.sendKeys(context.homePage.newDashboardAdd, "");
                break;
        }
        context.selenium_utils.logInfo("adding --> " +name, true);
    }
    //Best TLA-02
    @Then("Verify the error message appeared as existing TopicName already exists")
    public void verifyTheErrorMessageAppearedAsExistingTopicNameAlreadyExists() {
        // when user insert the topic that already been use the error message come up
        // I use list of topic name web element with loop to try to send key w all topic name
        context.selenium_utils.highlightElement(context.homePage.newDashboardAdd);
        for (int i = 0; i < context.homePage.topicName.size(); i++) {
            context.selenium_utils.sendKeys(context.homePage.newDashboardAdd,
                    context.homePage.topicName.get(i).getText());
            context.selenium_utils.click(context.homePage.addBtn);
            Assert.assertEquals(context.homePage.errorExistingNameMsg.getText().toLowerCase(),
                    "\'"+context.homePage.topicName.get(i).getText().toLowerCase()+"\'" +" already exists");
            context.selenium_utils.logInfo("adding --> existing  " + context.homePage.topicName.get(i).getText(), true);
        }
    }

    //@author: Best TLA-02
    @Then("verify each dash board has image present")
    public void verifyEachDashBoardHasImagePresent() {
        //check if dashboard contain picture by using the medthod verifyimageActive
        for (int i = 0; i < context.homePage.dash.size(); i++) {
            context.selenium_utils.highlightElement(context.homePage.dash.get(i));
            Assert.assertTrue(context.homePage.verifyimageActive(context.homePage.dash.get(i)));
            context.selenium_utils.logInfo("image presented --> " , true);

        }
    }
    //@author: Best TLA-02
    @Then("Verify each dashBoard contains own topic name")
    public void verifyEachDashBoardContainsOwnTopicName() {
        // check dashboard topic name element is present
        for (int i = 0; i < context.homePage.dash.size(); i++) {
            context.selenium_utils.highlightElement(context.homePage.topicName.get(i));
            Assert.assertTrue(context.homePage.topicName.get(i).isDisplayed());
            context.selenium_utils.logInfo("Topic name " +context.homePage.topicName.get(i).getText(), true);
        }
    }

    //@author: Best TLA-02
    @Then("Verify new dashboard has same name as as we created")
    public void verifyNewDashboardHasSameNameAsAsWeCreated() {
        //count if this topic is equal to 1 mean we already create that dashboard with this name
        System.out.println(topic);
        int count = 0;
        for (int i = 0; i < context.homePage.dash.size(); i++) {

            if (context.homePage.topicName.get(i).getText().equalsIgnoreCase(topic)) {
                count++;
            }
        }
        Assert.assertEquals(count, 1, topic + " appeared not 1 time");
        context.selenium_utils.logInfo("dashboard has name >> " +topic , true);

    }
    //@author: Best TLA-02
    @Then("Verify dashboard contains image")
    public void verifyDashboardContainsImage() {
        //the recent dashboard we just create will be at the last index so we use "verifyimageActive" to test if it contain picture
        Assert.assertTrue(context.homePage.verifyimageActive(context.homePage.dash.get(context.homePage.dash.size() - 1)));
        context.selenium_utils.logInfo("image presented --> " , true);
    }
    //@author: Best TLA-02
    @Then("Verify each DashBoard won't contain duplicate topicname")
    public void verifyEachDashBoardWonTContainDuplicateTopicname() {

        //use set to eliminate duplicate then compare if list will have more than set
        List<String> topicname = new ArrayList<>();
        for (int i = 0; i < context.homePage.topicName.size(); i++) {
            topicname.add(context.homePage.topicName.get(i).getText().toLowerCase());
        }
        Set<String> nonDup = new HashSet<>();
        for (int i = 0; i < topicname.size(); i++) {
            nonDup.add(topicname.get(i));
        }

        Assert.assertEquals(nonDup.size(), topicname.size());
        context.selenium_utils.logInfo(" DashBoard won't contain duplicate topicname" , true);

    }
    //--------------------------------------------------------------
    //-------------------------------------Muneer-started-----------
    /**
     * deleting dashboard based on name of the dashboard
     * TlA-13 admin role
     * @author: Muneer
     */
    String dashName = "";
    @When("I delete a {string}")
    public void i_delete_a(String dashboard) {
        dashName = dashboard;
        String xPath = String.format(HomePage.deleteBtnTemplate,dashboard);
        WebElement element = context.driver.findElement(By.xpath(xPath));
        context.selenium_utils.click(element);
        context.selenium_utils.logInfo("Deleting :" + dashboard, true);
    }

    /**
     * verify pop up warning is displayed
     * TlA-13 admin role
     * @author: Muneer
     */
    @Then("I verify Pop up warning message displayed")
    public void iVerifyPopUpWarningMessageDisplayed() {
        context.selenium_utils.sleep(1000);
        Assert.assertTrue(context.homePage.warningHeader.getText().contains("Warning"));
        context.selenium_utils.logInfo("Warning massage displayed", true);
    }

    /**
     * verify warning message contains number of question
     * TlA-13 admin role
     * @author: Muneer
     */
    @And("I verify Pup up waring message contain number of question is {string}")
    public void iVerifyPupUpWaringMessageContainNumberOfQuestionIs(String numberOfQuestion) {
        Assert.assertTrue(context.homePage.warningMsg.getText().contains(numberOfQuestion));
        context.selenium_utils.logInfo("Warning message contains: " + numberOfQuestion, true);
    }

    /**
     * verify dashboard is deleted and not deleted
     * TlA-13 admin role
     * @author: Muneer
     */
    @Then("I verify dashboard {string}")
    public void iVerifyDashboard(String delete) {
        switch (delete){
            case "deleted":
                context.selenium_utils.sleep(1000);
                String xPath = String.format(LogInPage.buttonXpath,dashName);
                Assert.assertTrue(context.driver.findElements(By.xpath(xPath)).size() == 0);
                context.selenium_utils.logInfo("confirm: "+ dashName + " is deleted.", true);
                break;
            case "not deleted":
                String xPath1 = String.format(LogInPage.buttonXpath,dashName);
                Assert.assertTrue(context.driver.findElement(By.xpath(xPath1)).isDisplayed());
                context.selenium_utils.logInfo("confirm: "+ dashName + " is not deleted.", true);
                break;
            default:
                System.out.println("Invalid option provided");
        }
    }

    /**
     * verify main dashboards is not deletable
     * TlA-13 admin role
     * @author: Muneer
     */
    @Then("I verify dashboard {string} doesn't have delete option")
    public void iVerifyDashboardDoesnTHaveDeleteOption(String dashboard) {
        //highlight dashboard
        String xPath1 = String.format(LogInPage.buttonXpath,dashboard);
        WebElement element = context.driver.findElement(By.xpath(xPath1));
        context.selenium_utils.highlightElement(element);
        // verify dashboard is not deletable
        String xPath = String.format(HomePage.deleteBtnTemplate,dashboard);
        List<WebElement> element1 = context.driver.findElements(By.xpath(xPath));
        Assert.assertTrue(element1.size()== 0);
        context.selenium_utils.logInfo("Verify: "+ dashboard + "is not Deletable", true);
    }

    /**
     * verifying visibility of adding new dashboard for admin
     * TlA-13 admin role
     * @author: Muneer
     */
    @Then("I verify adding {string} is visible only for admin")
    public void iVerifyAddingIsVisibleOnlyForAdmin(String option) {
        String xPath = String.format(LogInPage.inputXpath, option);
        WebElement element = context.driver.findElement(By.xpath(xPath));
        context.selenium_utils.highlightElement(element);
        Assert.assertTrue(element.isDisplayed());
        context.selenium_utils.logInfo("verify: " + option + " is displayed for admin.", true);

    }

    /**
     * getting number of question in each dashboard
     * TlA-13 admin role
     * @author: Muneer
     */
    int questionNum = 0;
    @And("user get number of questions")
    public void userGetNumberOfQuestions() {
        context.selenium_utils.sleep(1000);
        questionNum = context.dashboardPage.questions.size();
    }

    /**
     * verify warning message contain dashboard name
     * TlA-13 admin role
     * @author: Muneer
     */
    @Then("I verify Pop up warning message contains {string} and number of questions")
    public void iVerifyPopUpWarningMessageContainsAndNumberOfQuestions(String dashName) {
        Assert.assertTrue(context.homePage.warningMsg.getText().contains(dashName));
        System.out.println(questionNum);
        Assert.assertTrue(context.homePage.warningMsg.getText().contains(String.valueOf(questionNum)));
        context.selenium_utils.logInfo("Warning message contains: " + dashName, true);
    }
    //--------------------------------Muneer-Ended--------------------------------------------


}
