package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/a")
    public WebElement createAccountbtn;

    @FindBy(xpath="//button[@class='btn btn-primary mb-4']")
    public WebElement signInbtn;

    @FindBy(xpath="//div/input[@name='name']")
    public WebElement name;

    @FindBy(xpath="//div/input[@name='email']")
    public WebElement email;

    @FindBy(xpath="//div/input[@name='password']")
    public WebElement passwordbfSignup;

    @FindBy(xpath="//div/input[@name='password1']")
    public WebElement password;

    @FindBy(xpath="//div/input[@name='password2']")
    public WebElement confirmpassword;

    @FindBy(xpath="//button[@class='btn btn-primary mb-3']")
    public WebElement signUp;

    @FindBy(linkText = "Welcome")
    public WebElement welcomeText;

    @FindBy(xpath="//div[contains(text(),'invalid credentials')]")
    public WebElement inValidCredentials;

    @FindBy(xpath="//div[contains(text(),'Invalid email format')]")
    public WebElement invalidEmailformat;


    public static String buttonXpath = "//button[text()='%s']";
    public static String inputXpath = "//input[@placeholder='%s']";
    public static String errorMsgXpath = "//div[contains(text(),'%s')]";




}
