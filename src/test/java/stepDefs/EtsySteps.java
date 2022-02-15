package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import pages.EtsyPage;
import utility.BrowserUtil;
import utility.ConfigReader;
import utility.Driver;

import java.util.*;

public class EtsySteps {

    EtsyPage etsyPage =  new EtsyPage();
    String etsyWindow;
    Set<String>  allWindow= new LinkedHashSet<>();
    List<String> actualTitles= new ArrayList<>();

    @Given("user navigates to Etsy.com webpage")
    public void user_navigates_to_etsy_com_webpage() {

        Driver.getDriver().get(ConfigReader.read("etsyUrl"));
        BrowserUtil.waitFor(2);

    }

    @When("user scrolls down element on the down of the webpage")
    public void user_scrolls_down_element_on_the_down_of_the_webpage() {
         BrowserUtil.scrollingDown(etsyPage.instagram);
         BrowserUtil.waitFor(2);
    }

    @When("user clicks each elements to open new window")
    public void user_clicks_each_elements_to_open_new_window() {

         etsyWindow = Driver.getDriver().getWindowHandle();
        BrowserUtil.clickingMultipleLinks(etsyPage.allNewWindows);
         allWindow= Driver.getDriver().getWindowHandles();

    }

    @Then("user should able to switch windows and get title of each windows")
    public void user_should_able_to_switch_windows_and_get_title_of_each_windows(List<String> expectedTitles) {
        BrowserUtil.waitFor(2);
        actualTitles= BrowserUtil.switchingWindows(allWindow);

        for (int i = 0, j=0; i <actualTitles.size(); i++, j++) {

        Assert.assertTrue(actualTitles.get(i).contains(expectedTitles.get(j)));

        }

            BrowserUtil.waitFor(2);


    }




}
