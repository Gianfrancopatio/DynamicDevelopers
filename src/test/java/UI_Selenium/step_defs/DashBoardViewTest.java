package UI_Selenium.step_defs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class DashBoardViewTest {

    ScenarioContext context;
    Faker faker = new Faker();
    String topic = faker.animal().name();

    public DashBoardViewTest(ScenarioContext scenarioContext) {
        this.context = scenarioContext;
    }

    @When("User create new dashboard name with {string}")
    public void userCreateNewDashboardNameWith(String name) {

        switch (name.toLowerCase()) {
            case "newtopicname":
                context.selenium_utils.highlightElement(context.dashBoardViewPage.newDashboardAdd);
                context.selenium_utils.sendKeys(context.dashBoardViewPage.newDashboardAdd, topic);
                break;
        }
        switch (name.toLowerCase()) {
            case "existingtopicname":
                context.selenium_utils.highlightElement(context.dashBoardViewPage.newDashboardAdd);
                for (int i = 0; i < context.dashBoardViewPage.topicName.size() ; i++) {

                    context.selenium_utils.sendKeys(context.dashBoardViewPage.newDashboardAdd,
                            context.dashBoardViewPage.topicName.get(i).getText() );
                }
                break;
        }

    }

    @And("User click add button")
    public void userClickAddButton() {
        context.selenium_utils.highlightElement(context.dashBoardViewPage.addBtn);
        context.selenium_utils.click(context.dashBoardViewPage.addBtn);

    }

    @Then("Verify the error message appeared as existing TopicName already exists")
    public void verifyTheErrorMessageAppearedAsExistingTopicNameAlreadyExists() {
        // when user insert the topic that already been use the error message come up
        // I use list of topic name web element with loop to try to send key w all topic name
        System.out.println(context.dashBoardViewPage.topicName.get(0).getText());
        Assert.assertEquals(context.dashBoardViewPage.errorExist.getText(),
                "\'CSS\' already exists");
    }


    @Then("verify each dash board has image present")
    public void verifyEachDashBoardHasImagePresent() {
        //check if dashboard contain picture by using the medthod verifyimageActive
        for (int i = 0; i < context.dashBoardViewPage.dash.size(); i++) {
            context.selenium_utils.highlightElement(context.dashBoardViewPage.dash.get(i));
            Assert.assertTrue(context.dashBoardViewPage.verifyimageActive(context.dashBoardViewPage.dash.get(i)));
        }
    }

    @Then("Verify each dashBoard contains own topic name")
    public void verifyEachDashBoardContainsOwnTopicName() {
        // check dashboard topic name element is present
        for (int i = 0; i < context.dashBoardViewPage.dash.size(); i++) {
            context.selenium_utils.highlightElement(context.dashBoardViewPage.topicName.get(i));
            Assert.assertTrue(context.dashBoardViewPage.topicName.get(i).isDisplayed());
        }
    }


    @Then("Verify new dashboard has same name as as we created")
    public void verifyNewDashboardHasSameNameAsAsWeCreated() throws InterruptedException {
        //count if this topic is equal to 1 mean we already create that dashboard with this name
        System.out.println(topic);
        int count = 0;
        for (int i = 0; i < context.dashBoardViewPage.dash.size(); i++) {

            if (context.dashBoardViewPage.topicName.get(i).getText().equalsIgnoreCase(topic)) {
                count++;
            }
        }
        Assert.assertEquals(count, 1, topic + " appeared not 1 time");
    }

    @Then("Verify dashboard contains image")
    public void verifyDashboardContainsImage() {
        //the recent dashboard we just create will be at the last index so we use "verifyimageActive" to test if it contain picture
        Assert.assertTrue(context.dashBoardViewPage.verifyimageActive(context.dashBoardViewPage.dash.get(context.dashBoardViewPage.dash.size() - 1)));

    }

    @Then("Verify each DashBoard won't contain duplicate topicname")
    public void verifyEachDashBoardWonTContainDuplicateTopicname() {

        //use set to eliminate duplicate then compare if there is dublicate list will have more than set
        List<String> topicname = new ArrayList<>();
        for (int i = 0; i < context.dashBoardViewPage.topicName.size(); i++) {
            topicname.add(context.dashBoardViewPage.topicName.get(i).getText().toLowerCase());
        }
        Set<String> nonDup = new HashSet<>();
        for (int i = 0; i < topicname.size(); i++) {
            nonDup.add(topicname.get(i));
        }

        Assert.assertEquals(nonDup.size(), topicname.size());

    }


}
