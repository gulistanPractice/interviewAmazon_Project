package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Browser_Util;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class EtsyScroll {
    public EtsyScroll(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = " //a[@class='wt-btn wt-btn--transparent wt-btn--transparent-flush-left wt-btn--light " +
            "wt-btn--icon wt-p-xs-1']")
    public List<WebElement>  fiveIcons;

    @FindBy(xpath  =" (//a[@class='wt-btn wt-btn--transparent wt-btn--transparent-flush-left wt-btn" +
            "--light wt-btn--icon wt-p-xs-1'])[1]")
    public  WebElement instagramIcon;

    public void scroll(){
        JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true)",instagramIcon);
    }


    public void clickWindows(){
        for(WebElement eachWindow: fiveIcons){
            eachWindow.click();
            Browser_Util.waitFor(2);

        }

    }

    public Set<String> allWindowHandle(){
        Set<String> allWindow= Driver.getDriver().getWindowHandles();
        System.out.println(allWindow);


        return allWindow;
    }

}
