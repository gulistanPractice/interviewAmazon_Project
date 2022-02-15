package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( glue = "stepDefs",
        features = "@target/rerun.txt"
          //>> it will run all failed tests which have @ui tag feature or scenarios
)


public class FailedRunner {
}
