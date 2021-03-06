package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.IframePage;
import utilities.Browser_Util;
import utilities.ConfigReader;
import utilities.Driver;

public class IframeStep {
    IframePage iframeStep = new IframePage();

    @Given("navigates to Amazon homepage")
    public void navigates_to_amazon_homepage() {
        Driver.getDriver().get(ConfigReader.read("amazonUrl"));
    }
    @When("user locate iframe")
    public void user_locate_iframe() {
        Driver.getDriver().switchTo().frame(iframeStep.iframeId);
        Browser_Util.waitFor(2);

    }
    @Then("user should able to get attribute of iframe")
    public void user_should_able_to_get_attribute_of_iframe() {
        String name = iframeStep.attributeOfIframe.getAttribute("style");
        Assert.assertEquals("background-color: transparent;",name);
    }
}
