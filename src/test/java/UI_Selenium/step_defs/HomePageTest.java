package UI_Selenium.step_defs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

        }

        switch (name.toLowerCase()) {
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

    //Best TLA-02
    @Then("verify each dash board has image present")
    public void verifyEachDashBoardHasImagePresent() {
        //check if dashboard contain picture by using the medthod verifyimageActive
        for (int i = 0; i < context.homePage.dash.size(); i++) {
            context.selenium_utils.highlightElement(context.homePage.dash.get(i));
            Assert.assertTrue(context.homePage.verifyimageActive(context.homePage.dash.get(i)));
            context.selenium_utils.logInfo("image presented --> " , true);

        }
    }
    //Best TLA-02
    @Then("Verify each dashBoard contains own topic name")
    public void verifyEachDashBoardContainsOwnTopicName() {
        // check dashboard topic name element is present
        for (int i = 0; i < context.homePage.dash.size(); i++) {
            context.selenium_utils.highlightElement(context.homePage.topicName.get(i));
            Assert.assertTrue(context.homePage.topicName.get(i).isDisplayed());
            context.selenium_utils.logInfo("Topic name " +context.homePage.topicName.get(i).getText(), true);
        }
    }

    //Best TLA-02
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
    //Best TLA-02
    @Then("Verify dashboard contains image")
    public void verifyDashboardContainsImage() {
        //the recent dashboard we just create will be at the last index so we use "verifyimageActive" to test if it contain picture
        Assert.assertTrue(context.homePage.verifyimageActive(context.homePage.dash.get(context.homePage.dash.size() - 1)));
        context.selenium_utils.logInfo("image presented --> " , true);
    }
    //Best TLA-02
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




}
