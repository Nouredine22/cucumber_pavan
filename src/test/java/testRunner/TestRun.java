package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/main/resources/Features"},
        glue = {"stepDefinitions"},             // steps definition location
        dryRun = false,                          // dryRun= true, won't open the url
                                                // make the code look nice.
                                                 // cucumber report
        plugin = {"pretty","html:testOutPut"},    // html report
        tags = "@regression"
                )
public class TestRun {
}
