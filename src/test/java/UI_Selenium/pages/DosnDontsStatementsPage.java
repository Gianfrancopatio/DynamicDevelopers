package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DosnDontsStatementsPage {
    public DosnDontsStatementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//button[@class='btn btn-success badge-pill newbtn mb-3']")
                public WebElement doAddButton;

        @FindBy(xpath = "(//button[@class='btn btn-success badge-pill newbtn mb-3'])[2]")
                public WebElement dontAddButton;





}
