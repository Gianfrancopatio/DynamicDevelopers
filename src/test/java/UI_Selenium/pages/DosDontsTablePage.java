package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DosDontsTablePage {
    public DosDontsTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String templateXpath = "//div[text()='%s']";

}
