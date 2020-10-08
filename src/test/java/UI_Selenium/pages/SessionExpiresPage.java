package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionExpiresPage {
    public SessionExpiresPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email4;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password4;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signIn4;


    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    public WebElement welcomeBtn;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement signOutBtn;

    @FindBy(xpath = "//a[text()='Create an account']" )
    public WebElement createAccountBtn;
}
