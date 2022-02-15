package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.EbayPage;
import utility.BrowserUtil;
import utility.ConfigReader;
import utility.Driver;

import javax.sql.rowset.BaseRowSet;
import java.nio.channels.SelectableChannel;

public class EbayStepf {

    EbayPage page = new EbayPage();

    @Given("user on the cars and truck page")
    public void user_on_the_cars_and_truck_page() {
        Driver.getDriver().get(ConfigReader.read("ebayUrl"));
        BrowserUtil.waitFor(3);

    }


    @Given("on the filter section we need to fill the information")
    public void on_the_filter_section_we_need_to_fill_the_information() {
         page.chooseDropDrown("BMW","528i xDrive","Used","95843");
         BrowserUtil.waitFor(2);

    }


    @Given("click Find Vehicle button")
    public void click_find_vehicle_button() {
            page.findCars.click();
            BrowserUtil.waitFor(2);
    }

    @Then("verify page Title contains BMW")
    public void verify_page_title_contains_bmw() {
      String bmwPageTitle=  Driver.getDriver().getTitle();
        System.out.println(bmwPageTitle);
        Assert.assertTrue(bmwPageTitle.contains("bmw"));
    }


}
