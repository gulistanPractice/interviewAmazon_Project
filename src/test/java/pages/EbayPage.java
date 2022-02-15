package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import utility.BrowserUtil;
import utility.Driver;

import java.util.List;

public class EbayPage {

    public EbayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    Actions action = new Actions(Driver.getDriver());

    public void chooseDropDrown(String make, String model, String newOld,String zipCode){

       Select selectMakes=new Select(dropDownLst.get(0));
        Select selectModels=new Select(dropDownLst.get(1));
        Select selectNewOld=new Select(dropDownLst.get(dropDownLst.size()-1));

        selectMakes.selectByValue(make);
        BrowserUtil.waitFor(2);
        selectModels.selectByValue(model);
        BrowserUtil.waitFor(2);
        selectNewOld.selectByVisibleText(newOld);

        BrowserUtil.waitFor(2);


        action.click(zipCodeElement).pause(2000).keyDown(Keys.COMMAND).
           sendKeys("A").keyUp(Keys.COMMAND)
                .sendKeys(Keys.DELETE).pause(2000).sendKeys(Keys.UP).sendKeys(zipCode).perform();

        BrowserUtil.waitFor(2);

    }




    @FindBy(xpath = "//span[@class='select motors-finder-menu']/select")
    public List<WebElement> dropDownLst;



    @FindBy(xpath = "//input[@class='textbox__control']")
    public WebElement zipCodeElement;

    @FindBy(css = "#s0-27_1-9-0-1\\[0\\]-0-1-2-14\\[0\\[0\\]\\]")
    public WebElement findCars;




}
