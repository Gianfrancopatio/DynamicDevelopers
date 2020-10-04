package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DosDontsTablePage {
    public DosDontsTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()=' Send a personalized thank you letter after the interview']")
    public WebElement doTable;

    @FindBy(xpath = "//div[text()='Keep a positive and friendly attitude']")
    public WebElement doTable1;

    @FindBy(xpath = "//div[text()='Not listening or responding to the questions']")
    public WebElement dontsTable;

    @FindBy(xpath = "//div[text()='Appearing arrogant']")
    public WebElement dontsTable1;
}
