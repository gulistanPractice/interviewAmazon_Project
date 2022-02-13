package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IframePage {

    public IframePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//iframe[@id='DAsis']")
    public WebElement iframe;

    @FindBy(xpath = "//html/body")
    public WebElement attribute;


}
