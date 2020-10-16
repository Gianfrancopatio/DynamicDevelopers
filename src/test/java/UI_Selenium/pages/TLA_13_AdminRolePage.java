package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TLA_13_AdminRolePage {
    public TLA_13_AdminRolePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//form[@class='form-inline']//div//div[@id='x'])[13]")
    public WebElement deleteBtn;
}
