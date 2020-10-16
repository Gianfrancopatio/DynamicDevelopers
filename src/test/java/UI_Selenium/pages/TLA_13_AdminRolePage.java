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

    @FindBy(xpath = "//div[@id='x']")
    public List<WebElement> deleteBtn;

    @FindBy(xpath = "//h1[text()='Warning']")
    public WebElement warningHeader;

    @FindBy(xpath = "//div//h4[contains(text(),'Are you sure')]")
    public WebElement warningMsg;

    public static String deleteStr = "(//div[@id='x'])[%s]";

    public static String deleteBtnTemplate = "//form//div//button[text()='%s']/parent::a/following-sibling::div";


}
