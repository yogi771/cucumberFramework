package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= ".//Features/demowebshop.feature",
		glue="stepDefinitations",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html: test-output","json:target/cucumber.json","rerun:target/rerun.txt"}
		)

public class TestRun {	
	
}
