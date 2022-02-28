package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonLogin {

    public AmazonLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    public WebElement signinBtn;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailBox;



    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement helloSign;

    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    public WebElement signinSubmit;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueBtn;

    public void clickSignin(){
        signinBtn.click();
    }

    public void signInMajor(String email, String password){

        emailBox.sendKeys(email);
        continueBtn.click();
        passwordBox.sendKeys(password);
        signinSubmit.click();

    }

    public String helloPeople(){
       return helloSign.getText();
       //hello

    }


}

