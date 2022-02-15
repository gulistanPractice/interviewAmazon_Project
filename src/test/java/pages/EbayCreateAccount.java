package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Browser_Util;
import utilities.Driver;

import java.util.List;

public class EbayCreateAccount {
    public EbayCreateAccount(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void choseDropDown(String make, String model,String condition,String zip){

        Actions actions = new Actions(Driver.getDriver());

        Select allMakes = new Select(dropDownList.get(0));
        Select allModels = new Select(dropDownList.get(1));
        Select newOrOld = new Select(dropDownList.get(2));

        allMakes.selectByValue(make);
        Browser_Util.waitFor(3);
        allModels.selectByValue(model);
        Browser_Util.waitFor(2);
        newOrOld.selectByVisibleText(condition);
        Browser_Util.waitFor(2);

        Browser_Util.waitFor(5);

        actions.click(zipCode).pause(2000).keyDown(Keys.COMMAND).
                sendKeys("A").keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE).pause(2000).sendKeys(Keys.UP).sendKeys(zip).perform();
    }



//    @FindBy(xpath = "//span[@class='select motors-finder-menu']")
//    public WebElement dropDowns;

    @FindBy(xpath = "//span[@class='select motors-finder-menu']/select")
    public List<WebElement> dropDownList;

    @FindBy(xpath = "//input[@class='textbox__control']")
    public WebElement zipCodeDropDown;

    @FindBy(css = "#s0-27_1-9-0-1\\[0\\]-0-1-2-14\\[0\\[0\\]\\]")
    public WebElement findVihicle;

    @FindBy(xpath = "//span/input[@class='textbox__control']")
    public WebElement zipCode;

    public void clickFindVihicle(){
       findVihicle.click();
    }




}
