package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserUtil;
import utility.Driver;

import javax.sql.rowset.BaseRowSet;

public class AmazonLoginPage {

    public AmazonLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement signForLogin;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    public WebElement signInBtn;


    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    public WebElement verificationMsg;



    public void loginProcess(String username, String password){

        emailInput.sendKeys(username);
        BrowserUtil.waitFor(2);
        continueBtn.click();
        BrowserUtil.waitFor(2);
        passwordBox.sendKeys(password);
        BrowserUtil.waitFor(2);
        signInBtn.click();

        BrowserUtil.waitFor(2);



    }




}
