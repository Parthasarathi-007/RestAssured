package cucumber.Options;

import org.junit.runner.RunWith;
//import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	
		features = "src/test/java/features/placeValidations.feature",
				plugin = {"pretty","json:target/jsonReports/cucumber-report.json"},
		
						glue = "stepDefinitions"
		
		
		)

public class TestRunner {

}
