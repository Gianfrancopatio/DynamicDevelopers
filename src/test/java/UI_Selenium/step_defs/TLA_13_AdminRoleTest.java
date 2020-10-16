package UI_Selenium.step_defs;


import UI_Selenium.pages.HomePage;
import UI_Selenium.pages.LogInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TLA_13_AdminRoleTest {
    ScenarioContext context;
    public TLA_13_AdminRoleTest(ScenarioContext scenarioContext){
        context = scenarioContext;
    }

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
}
