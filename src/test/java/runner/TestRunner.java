package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
              glue = "stepDefs",
        publish = true,
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",  // store the failed scenario into rerun.txt
                "me.jvt.cucumber.report.PrettyReports:target" //this is fancy report
        }
        //,dryRun = true
        ,tags = "@smoke"


)
public class TestRunner {


}
