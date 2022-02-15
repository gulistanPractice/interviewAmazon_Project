package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AmazonLogin;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonLoginStep {

    AmazonLogin amazonLogin = new AmazonLogin();

    @Given("user navigates to the Amazon webpage")
    public void user_navigates_to_the_amazon_webpage() {
        Driver.getDriver().get(ConfigReader.read("amazonUrl"));
    }
    @When("user click on the sign in button")
    public void user_click_on_the_sign_in_button() {
        amazonLogin.clickSignin();
    }
    @When("user provide correct username {string} and password {string}")
    public void user_provide_correct_username_and_password(String email, String password) {
       amazonLogin.signInMajor(email,password);
    }
    @Then("verify user logged in successfully {string}")
    public void verify_user_logged_in_successfully(String expectedMessage) {
        Assert.assertEquals(expectedMessage,amazonLogin.helloPeople());

    }
}
