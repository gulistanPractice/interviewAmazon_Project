package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.EbayCreateAccount;
import utilities.ConfigReader;
import utilities.Driver;


public class EbayFindCarStep {
    EbayCreateAccount ebayCreateAccount = new EbayCreateAccount();

    @Given("user on the cars and truck page")
    public void user_on_the_cars_and_truck_page() {
       Driver.getDriver().get(ConfigReader.read("ebayUrl"));
    }

    @Given("on the filter section we need to fill the information")
    public void on_the_filter_section_we_need_to_fill_the_information() {
        ebayCreateAccount.choseDropDown("BMW","130i","Used","95112");
    }
    @Given("click Find Vehicle button")
    public void click_find_vehicle_button() {
        ebayCreateAccount.clickFindVihicle();

    }
    @Then("verify page Title contains BMW")
    public void verify_page_title_contains_bmw() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("bmw"));
    }

}
