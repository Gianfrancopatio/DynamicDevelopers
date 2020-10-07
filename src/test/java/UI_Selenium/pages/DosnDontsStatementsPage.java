package UI_Selenium.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DosnDontsStatementsPage {
    public DosnDontsStatementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
       @FindBy(xpath = "//input[@name='email']")
                public WebElement email4;
       @FindBy(xpath = "//input[@name='password']")
                public WebElement password4;
       @FindBy(xpath = "//button[text()='Sign in']")
                public WebElement signIn4;



        @FindBy(xpath = "//button[@class='btn btn-success badge-pill newbtn mb-3']")
                public WebElement doAddButton;
        @FindBy(xpath = "//textarea[@id='inputArea1']")
                public WebElement textBox;
        @FindBy(xpath = "(//button[@type='submit'])[24]")
                public WebElement submitButton;
        @FindBy(xpath = "//div[text()='New Statements']")
                public WebElement doStatement;





        @FindBy(xpath = "(//button[@class='btn btn-success badge-pill newbtn mb-3'])[2]")
                public WebElement dontAddButton;
        @FindBy(xpath = "//textarea[@id='inputArea2']")
                public WebElement textBoxEntry;
        @FindBy(xpath = "(//button[@type='submit'])[25]")
                public WebElement submitButton1;
        @FindBy(xpath = "//div[text()='Second Statements']")
                public WebElement dontsStatement;







}
