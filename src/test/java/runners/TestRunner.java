package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",  // store the failed scenario into rerun.txt
                "me.jvt.cucumber.report.PrettyReports:target" //this is fancy report
        }
        ,publish=false
        ,dryRun = false
        ,tags = "@ebayCreateAccount"


)

public class TestRunner {


}
