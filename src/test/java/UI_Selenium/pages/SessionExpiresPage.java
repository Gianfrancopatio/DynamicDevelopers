package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionExpiresPage {
    public SessionExpiresPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='dropdown-menu']")
    public WebElement welcomeBtn;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement signOutBtn;

    @FindBy(xpath = "//a[text()='Create an account']" )
    public WebElement createAccountBtn;
}
