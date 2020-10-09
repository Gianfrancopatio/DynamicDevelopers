package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DosDontsTablePage {
    public DosDontsTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email15;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password15;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signIn15;

    @FindBy(xpath = "//div[text()=' Send a personalized thank you letter after the interview']")
    public WebElement doTable;

    @FindBy(xpath = "//div[text()='Keep a positive and friendly attitude']")
    public WebElement doTable1;

    @FindBy(xpath = "//div[text()='Not listening or responding to the questions']")
    public WebElement dontsTable;

    @FindBy(xpath = "//div[text()='Appearing arrogant']")
    public WebElement dontsTable1;
}
