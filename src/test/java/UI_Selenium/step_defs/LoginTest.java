package UI_Selenium.step_defs;

import UI_Selenium.pages.LogInPage;
import com.github.javafaker.Faker;
import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class LoginTest {
    ScenarioContext context;

    public LoginTest(ScenarioContext scenarioContext) {

        this.context = scenarioContext;
    }


    @Given("I open login page")
    public void i_open() {
        context.driver.get(ConfigReader.readProperty
                ("projectURL", "src/test/resources/properties/configuration.properties"));
    }


    @When("user click create new account")
    public void userIsAbleToClickCreateNewAccount() throws InterruptedException {
        Thread.sleep(1000);
        context.selenium_utils.click(context.logInPage.createAccountbtn);
    }

    @And("user provides following data")
    public void userProvidesFollowingData(Map<String, String> dataInput) {

        context.selenium_utils.sendKeys(context.logInPage.name, dataInput.get("name"));
        context.selenium_utils.sendKeys(context.logInPage.email, dataInput.get("email"));
        context.selenium_utils.sendKeys(context.logInPage.password, dataInput.get("password"));
        context.selenium_utils.sendKeys(context.logInPage.confirmpassword, dataInput.get("confirmpassword"));

    }

    @Then("user click on signup button")
    public void userClickOnSighupButton() {

        context.selenium_utils.click(context.logInPage.signUp);
    }


    @Then("verify {string}  exists")
    public void verifyExists(String field) throws InterruptedException {

        switch (field.toLowerCase()) {
            case "emailfield":
                Thread.sleep(1000);
                context.selenium_utils.highlightElement(context.logInPage.email);
                Assert.assertTrue(context.logInPage.email.isDisplayed());
                break;
            case "passwordfield":
                Thread.sleep(1000);
                context.selenium_utils.highlightElement(context.logInPage.passwordbfSignup);
                Assert.assertTrue(context.logInPage.passwordbfSignup.isDisplayed());
                break;
            case "signinbutton":
                Thread.sleep(1000);
                context.selenium_utils.highlightElement(context.logInPage.signInbtn);
                Assert.assertTrue(context.logInPage.signInbtn.isDisplayed());
                break;
            case "CreateAccountButton":
                Thread.sleep(1000);
                context.selenium_utils.highlightElement(context.logInPage.createAccountbtn);
                Assert.assertTrue(context.logInPage.createAccountbtn.isDisplayed());
                break;
            case "namefield":
                Thread.sleep(1000);
                context.selenium_utils.highlightElement(context.logInPage.name);
                Assert.assertTrue(context.logInPage.name.isDisplayed());
                break;
            case "confirmpasswordfield":
                Thread.sleep(2000);
                context.selenium_utils.highlightElement(context.logInPage.confirmpassword);
                Assert.assertTrue(context.logInPage.confirmpassword.isDisplayed());
                break;
            default:
                Thread.sleep(1000);
                System.out.println("fields are not existed " + field);
        }
        context.selenium_utils.logInfo("verify " + field + "  exists", true);
    }


    @Then("verify sign up button is not enable")
    public void verifySignUpButtonIsNotEnable() {
        Assert.assertFalse(context.logInPage.signUp.isEnabled());
        context.selenium_utils.logInfo("verify sign up button is not enable", true);

    }

    @And("user provides {string} {string} {string} {string}")
    public void userProvidesNameEmailPasswordConfirmPassword(String name, String email, String pass, String conPass) {

        context.selenium_utils.sendKeys(context.logInPage.name, name);
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.password, pass);
        context.selenium_utils.sendKeys(context.logInPage.confirmpassword, conPass);
        context.selenium_utils.logInfo("user provide name,email,password and confirm password to sign up", true);

    }


    @When("user provides valid Email")
    public void userProvidesValidEmail() {
        context.selenium_utils.sendKeys
                (context.logInPage.email, ConfigReader.readProperty("email",
                        "src/test/resources/properties/configuration.properties"));
    }

    @And("user provides valid password")
    public void userProvidesValidPassword() {
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, ConfigReader
                .readProperty("password", "src/test/resources/properties/configuration.properties"));
        context.selenium_utils.logInfo("user provides valid password", true);
    }


    @Then("verify user on DevPrepp page")
    public void verifyUserOnDevPreppPage() {
        Assert.assertTrue(context.logInPage.welcomeText.isDisplayed());
        context.selenium_utils.logInfo("Verify welcome text is displayed", true);

    }

    @When("user provides invalid Email")
    public void userProvidesInvalidEmail() {
        context.selenium_utils.sendKeys(context.logInPage.email, "devDDinvalid@gmail.com");
        context.selenium_utils.logInfo("User Provides Invalid Email", true);
    }

    @Then("verify the error message is up as invalid credentials")
    public void verifyTheErrorMessageIsUpAsInvalidCredentials() {
        Assert.assertTrue(context.logInPage.inValidCredentials.isDisplayed());
    }

    @And("user provides invalid password")
    public void userProvidesInvalidPassword() {
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, "dd879000");
        context.selenium_utils.logInfo("user provides invalid password", true);
    }


    @And("user provides following data with random name and email")
    public void userProvidesFollowingDataWithRandomNameAndEmail(Map<String, String> dataInput) {
        Faker faker = new Faker();
        String name = faker.funnyName().name();
        String email = faker.internet().emailAddress();

        context.selenium_utils.sendKeys(context.logInPage.name, name);
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.password, dataInput.get("password"));
        context.selenium_utils.sendKeys(context.logInPage.confirmpassword, dataInput.get("confirmpassword"));
        context.selenium_utils.logInfo("user provides following data with random name , email and password", true);

    }

    @And("user click on {string} button")
    public void userClickOnButton(String buttonName) {
        String xPath = String.format(LogInPage.buttonXpath, buttonName);
        //xpath = //button[text()='Login']
        WebElement element = context.driver.findElement(By.xpath(xPath));
        context.selenium_utils.click(element);
    }

    @Then("verify the error message is up as {string}")
    public void verifyTheErrorMessageIsUpAs(String msg) {
        String xPath = String.format(LogInPage.errorMsgXpath, msg);
        WebElement element = context.driver.findElement(By.xpath(xPath));
        context.selenium_utils.highlightElement(element);
        Assert.assertTrue(element.isDisplayed());
        context.selenium_utils.logInfo(msg + "is displayed", true);

    }

    @When("user provides valid {string} Email and password")
    public void userProvidesValidEmailandpassword(String role) {
        switch (role.toLowerCase()){
            case "user":
                context.selenium_utils.sendKeys
                        (context.logInPage.email, ConfigReader.readProperty("email",
                                "src/test/resources/properties/configuration.properties"));
                context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, ConfigReader
                        .readProperty("password", "src/test/resources/properties/configuration.properties"));
                context.selenium_utils.logInfo("user provides valid email and password", true);
                break;

            case "admin":
                context.selenium_utils.sendKeys
                        (context.logInPage.email, ConfigReader.readProperty("adminEmail",
                                "src/test/resources/properties/configuration.properties"));
                context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, ConfigReader
                        .readProperty("adminPassWord", "src/test/resources/properties/configuration.properties"));
                context.selenium_utils.logInfo("user provides valid email and password", true);

                break;

        }
    }


}


