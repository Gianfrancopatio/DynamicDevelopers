package UI_Selenium.step_defs;


import UI_Selenium.pages.TLA_13_AdminRolePage;
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

    int dashCount = 0;
    @When("I delete a {string}")
    public void i_delete_a(String dashboard) {
        dashCount = context.tla_13_adminRolePage.deleteBtn.size();
        context.selenium_utils.sleep(1000);
        String xPath = String.format(TLA_13_AdminRolePage.deleteBtnTemplate,dashboard);
        WebElement element = context.driver.findElement(By.xpath(xPath));
        context.selenium_utils.click(element);
    }

    @Then("I verify Pop up warning message displayed")
    public void iVerifyPopUpWarningMessageDisplayed() {
        context.selenium_utils.sleep(1000);
        Assert.assertTrue(context.tla_13_adminRolePage.warningHeader.getText().contains("Warning"));
    }

    @And("I verify Pup up waring message contain number of question is {string}")
    public void iVerifyPupUpWaringMessageContainNumberOfQuestionIs(String numberOfQuestion) {
        Assert.assertTrue(context.tla_13_adminRolePage.warningMsg.getText().contains(numberOfQuestion));
    }

    @Then("I verify dashboard {string}")
    public void iVerifyDashboard(String delete) {
        switch (delete){
            case "deleted":
                context.selenium_utils.sleep(1000);
                System.out.println(dashCount);
                System.out.println(context.tla_13_adminRolePage.deleteBtn.size());
                Assert.assertTrue(dashCount == context.tla_13_adminRolePage.deleteBtn.size());
                break;
            case "not deleted":
                System.out.println(dashCount);
                System.out.println(context.tla_13_adminRolePage.deleteBtn.size());
                Assert.assertTrue(dashCount == context.tla_13_adminRolePage.deleteBtn.size());
                break;
            default:
                System.out.println("Invalid option provided");
        }
    }


    @Then("I verify dashboard {string} doesn't have delete option")
    public void iVerifyDashboardDoesnTHaveDeleteOption(String dashboard) {
        String xPath = String.format(TLA_13_AdminRolePage.deleteBtnTemplate,dashboard);
        List<WebElement> element = context.driver.findElements(By.xpath(xPath));
        Assert.assertTrue(element.size()== 0);
    }
}
