package UI_Selenium.step_defs;

import UI_Selenium.pages.LogInPage;
import com.github.javafaker.Faker;
import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginTest {
    ScenarioContext context;

    public LoginTest(ScenarioContext scenarioContext){

        this.context = scenarioContext;
    }


    @Given("I open login page")
    public void i_open() {
        context.driver.get(ConfigReader.readProperty
                ("projectURL","src/test/resources/properties/configuration.properties"));
    }


    @When("user click create new account")
    public void userIsAbleToClickCreateNewAccount() throws InterruptedException {
        Thread.sleep(3000);
        context.selenium_utils.click(context.logInPage.createAccountbtn);
    }

    @And("user provides following data")
    public void userProvidesFollowingData(Map<String,String> dataInput) {
        Faker faker = new Faker();
        String name = faker.funnyName().name();
        String email = faker.internet().emailAddress(name);

        if(dataInput.get("name").equals("null")){
            context.logInPage.name.sendKeys("");
            context.selenium_utils.sendKeys(context.logInPage.email, dataInput.get("email"));
            context.selenium_utils.sendKeys(context.logInPage.password, dataInput.get("password"));
            context.selenium_utils.sendKeys(context.logInPage.confirmpassword, dataInput.get("confirmpassword"));
        }else{
        context.selenium_utils.sendKeys(context.logInPage.name, dataInput.get("name"));
        context.selenium_utils.sendKeys(context.logInPage.email, dataInput.get("email"));
        context.selenium_utils.sendKeys(context.logInPage.password, dataInput.get("password"));
        context.selenium_utils.sendKeys(context.logInPage.confirmpassword, dataInput.get("confirmpassword"));
        }


    }

    @Then("user click on signup button")
    public void userClickOnSighupButton() {

        context.selenium_utils.click(context.logInPage.signUp);
    }

    @Then("verify message Successfully signed up! is up")
    public void verifyMessageSuccessfullySignedUpIsUp() {
        Assert.assertTrue(context.logInPage.SuccessfullyText.isDisplayed());
    }

    @Then("verify message The user already exists is up")
    public void verifyMessageTheUserAlreadyExistsIsUp() {
        context.selenium_utils.highlightElement(context.logInPage.userexists);
        Assert.assertTrue(context.logInPage.userexists.isDisplayed());
    }


    @Then("verify the error message is up as Password must be at least six characters in length.")
    public void verifyTheErrorMessageIsUpAsPasswordMustBeAtLeastCharactersInLength() {
        context.selenium_utils.highlightElement(context.logInPage.passwordDigiterror);
        Assert.assertTrue(context.logInPage.passwordDigiterror.isDisplayed());
        Assert.assertEquals(context.logInPage.passwordDigiterror.getText(),"Password must be at least 6 characters in length.");
    }

    @Then("verify {string}  exists")
    public void verifyExists(String field) throws InterruptedException {

            switch (field.toLowerCase()){
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
                    System.out.println("fields are not existed "+ field);
            }
    }

    @Then("verify message The passwords did not match is up")
    public void verifyMessageThePasswordsDidNotMatchIsUp() throws InterruptedException {
        context.selenium_utils.highlightElement(context.logInPage.unmatchConfirmPassword);
        Assert.assertTrue(context.logInPage.unmatchConfirmPassword.isDisplayed());
        Thread.sleep(2000);

    }

    @Then("verify sign up button is not enable")
    public void verifySignUpButtonIsNotEnable() {
            Assert.assertFalse(context.logInPage.signUp.isEnabled());

    }

    @And("user provides {string} {string} {string} {string}")
    public void userProvidesNameEmailPasswordConfirmPassword(String name, String email, String pass, String conPass) {

            context.selenium_utils.sendKeys(context.logInPage.name, name);
            context.selenium_utils.sendKeys(context.logInPage.email, email);
            context.selenium_utils.sendKeys(context.logInPage.password, pass);
            context.selenium_utils.sendKeys(context.logInPage.confirmpassword, conPass);

    }


    @When("user provides valid Email")
    public void userProvidesValidEmail() {
        context.selenium_utils.sendKeys(context.logInPage.email,ConfigReader.readProperty("email","src/test/resources/properties/configuration.properties"));
    }

    @And("user provides valid password")
    public void userProvidesValidPassword() {
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup,ConfigReader
                .readProperty("password","src/test/resources/properties/configuration.properties"));
    }

    @And("user click on signIn button")
    public void userClickOnSignInButton() {
        context.selenium_utils.click(context.logInPage.signInbtn);
    }

    @Then("verify user on DevPrepp page")
    public void verifyUserOnDevPreppPage() {
        Assert.assertTrue(context.logInPage.welcomeText.isDisplayed());
    }

    @When("user provides invalid Email")
    public void userProvidesInvalidEmail() {
       context.selenium_utils.sendKeys(context.logInPage.email,"devDDinvalid@gmail.com");
    }

    @Then("verify the error message is up as invalid credentials")
    public void verifyTheErrorMessageIsUpAsInvalidCredentials() {
        Assert.assertTrue(context.logInPage.inValidCredentials.isDisplayed());
    }

    @And("user provides invalid password")
    public void userProvidesInvalidPassword() {
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup,"dd879000");
    }


    @Then("verify the error message is up as Invalid email format")
    public void verifyTheErrorMessageIsUpAsInvalidEmailFormat() {
        context.selenium_utils.highlightElement(context.logInPage.invalidEmailformat);
        Assert.assertEquals(context.logInPage.invalidEmailformat.getText(),"Invalid email format");
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

    }
}


