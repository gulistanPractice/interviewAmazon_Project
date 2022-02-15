package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Driver;

public class IframePage {

    public IframePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"DAsis\"]")
    public WebElement iframeId;

    @FindBy(xpath = "//html/body")
    public WebElement attributeOfIframe;




}
