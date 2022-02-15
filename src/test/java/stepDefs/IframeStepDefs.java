package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IframePage;
import utility.BrowserUtil;
import utility.ConfigReader;
import utility.Driver;

public class IframeStepDefs {

    IframePage iframePage= new IframePage();

    @Given("navigates to Amazon homepage")
    public void navigates_to_amazon_homepage() {
        Driver.getDriver().get(ConfigReader.read("amazonUrl"));
        BrowserUtil.waitFor(3);
    }


    @When("user locate iframe")
    public void user_locate_iframe() {
        Driver.getDriver().switchTo().frame(iframePage.iframeId);
        BrowserUtil.waitFor(3);
    }



    @Then("user should able to get attribute of iframe")
    public void user_should_able_to_get_attribute_of_iframe() {
       String str=iframePage.attributeOfIframe.getAttribute("style");
        System.out.println(str);
        Assert.assertTrue(iframePage.attributeOfIframe.getAttribute("style").startsWith("background"));

        Driver.getDriver().switchTo().defaultContent();

        BrowserUtil.waitFor(3);

    }



}
