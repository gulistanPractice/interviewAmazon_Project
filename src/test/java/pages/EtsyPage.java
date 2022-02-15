package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class EtsyPage {

    public EtsyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//a[@class='wt-btn wt-btn--transparent " +
            "wt-btn--transparent-flush-left wt-btn--light wt-btn--icon wt-p-xs-1']")
    public List<WebElement> allNewWindows;


    @FindBy(xpath = " (//a[@class='wt-btn wt-btn--transparent " +
            "wt-btn--transparent-flush-left wt-btn--light wt-btn--icon wt-p-xs-1'])[1]")
    public WebElement instagram;







}
