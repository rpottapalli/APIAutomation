package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:/Users/ramaiah.pottapalli/eclipse-workspace/CucumberFramework/src/test/java/features/addplaceValidation.feature",
          plugin="json:target/jsonReports/cucumber-report.json",glue="stepDefinitions")
public class TestRunner {
	
}
