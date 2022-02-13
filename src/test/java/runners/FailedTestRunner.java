package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( glue = "stepDefinitions",
        features = "@target/rerun.txt",
        tags =""  //>> it will run all failed tests which have @ui tag feature or scenarios
)


public class FailedTestRunner {
}


