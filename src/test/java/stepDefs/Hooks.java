package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setUpDriver(){
        System.out.println("This is from @Before inside Hook class");
        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }





    @After()
    public void tearDown(Scenario scenario){
        System.out.println("THIS IS FROM @After inside Hooks class");
        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver() ;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // this is the line to attach screenshot to scenario
            scenario.attach(screenshot,"image/png",scenario.getName());
        }

        Driver.closeBrowser();

    }




}
