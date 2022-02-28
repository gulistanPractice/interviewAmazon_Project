package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmazonLogin;
import utilities.Browser_Util;
import utilities.ConfigReader;
import utilities.Driver;


public class AmazonLoginStep {

    AmazonLogin amazonPage = new AmazonLogin();

    @Given("user navigates to the Amazon webpage")
    public void user_navigates_to_the_amazon_webpage() {
        Driver.getDriver().get(ConfigReader.read("amazonUrl"));
        Browser_Util.waitFor(2);
    }

    @When("user click on the sign in button")
    public void user_click_on_the_sign_in_button() {
        amazonPage.signinBtn.click();
        Browser_Util.waitFor(2);
    }

    @When("user provide correct username {string} and password {string}")
    public void user_provide_correct_username_and_password(String username, String password) {
        amazonPage.signInMajor(username,password);
        Browser_Util.waitFor(3);
    }


    @Then("verify user logged in successfully {string}")
    public void verify_user_logged_in_successfully(String verifyMessage) {

        System.out.println(amazonPage.helloSign.getText());
        Assert.assertTrue(amazonPage.helloSign.isDisplayed());
        Assert.assertEquals(verifyMessage,amazonPage.helloSign.getText() );
    }




}
