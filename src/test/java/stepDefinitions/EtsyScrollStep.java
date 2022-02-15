package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.EtsyScroll;
import utilities.Browser_Util;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class EtsyScrollStep {
    EtsyScroll etsyScroll = new EtsyScroll();
    String etsyWindow;
    List<String> actualTitles;
    Set<String> allWindow;

    @Given("user navigates to Etsy.com webpage")
    public void user_navigates_to_etsy_com_webpage() {
        Driver.getDriver().get(ConfigReader.read("etsyUrl"));
    }
    @When("user scrolls down element on the down of the webpage")
    public void user_scrolls_down_element_on_the_down_of_the_webpage() {
        etsyScroll.scroll();
        Browser_Util.waitFor(5);
    }
    @When("user clicks each elements to open new window")
    public void user_clicks_each_elements_to_open_new_window() {

        etsyWindow = Driver.getDriver().getWindowHandle();
        etsyScroll.clickWindows();
        etsyScroll.allWindowHandle();

    }



    @Then("user should able to switch windows and get title of each elements")
    public void user_should_able_to_switch_windows_and_get_title_of_each_elements(List<String> expectedTitle) {

        Browser_Util.waitFor(2);
        actualTitles = Browser_Util.switchingWindows(allWindow);
        System.out.println(actualTitles);

        for (int i = 0, j=0; i <actualTitles.size(); i++, j++) {

            Assert.assertTrue(actualTitles.get(i).contains(expectedTitle.get(j)));

        }
        Driver.getDriver().switchTo().window(etsyWindow);
        Browser_Util.waitFor(2);

    }

}
